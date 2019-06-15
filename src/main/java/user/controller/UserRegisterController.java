package user.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import user.domain.UserVO;
import user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserRegisterController {

    @Autowired
    private UserService userService;

    //회원가입 페이지 이동
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerGET() throws Exception{
        return "/user/register";
    }

    //회원가입 처리
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPOST(UserVO userVO, RedirectAttributes redirectAttributes) throws Exception {
        System.out.println(userVO.toString());
        String hashPw = BCrypt.hashpw(userVO.getUserPw(), BCrypt.gensalt());
        userVO.setUserPw(hashPw);
        userService.register(userVO);

        redirectAttributes.addFlashAttribute("msg", "회원가입완료");

        return "redirect:/user/login";
    }

}
