package user.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;
import user.domain.LoginDTO;
import user.domain.UserVO;
import user.service.UserService;
//왜인지 모르지만 직접 폴더 경로를 설정에서 잡아줘야 했다. 인텔리 J 가 못잡아줌
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    private UserService userService;

    //로그인 페이지로 이동
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(@ModelAttribute("loginDTO") LoginDTO loginDTO){
        return "/user/login";
    }

    //로그인 처리
    @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
    public void loginPost(LoginDTO loginDTO, HttpSession httpSession, Model model) throws Exception {

        UserVO userVO = userService.login(loginDTO);

        System.out.println(userVO.toString());
        System.out.println(loginDTO.toString());
        System.out.println( !BCrypt.checkpw(loginDTO.getUserPw(), userVO.getUserPw()));

        if(userVO == null || !BCrypt.checkpw(loginDTO.getUserPw(), userVO.getUserPw())){
            //여기서 메소드가 종료되고 loginPost.jsp로 넘어간다.
//            return;
        }
        model.addAttribute("user", userVO);

        // 로그인 유지 선택시
        if(loginDTO.isUseCookie()){
            int amount = 60 * 60 * 24 * 7; //일주일
            Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount)); //로그인 유지기간
            userService.keepLogin(userVO.getUserId(), httpSession.getId(), sessionLimit);
        }
    }

    //로그아웃 처리
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request,
                         HttpServletResponse response,
                         HttpSession httpSession) throws Exception {

        Object object = httpSession.getAttribute("login");
        if(object != null){
            UserVO userVO = (UserVO) object;
            httpSession.removeAttribute("login");
            httpSession.invalidate(); //세션 무효화

            Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
            //사용자가 로그인 유지를 했다면
            if(loginCookie != null){
                loginCookie.setPath("/");
                loginCookie.setMaxAge(0);
                response.addCookie(loginCookie);
                userService.keepLogin(userVO.getUserId(), "none", new Date());
            }
        }
        return "/user/logout";
    }
}
