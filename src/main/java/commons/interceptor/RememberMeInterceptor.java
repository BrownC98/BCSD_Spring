package commons.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;
import user.domain.UserVO;
import user.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RememberMeInterceptor  extends HandlerInterceptorAdapter {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession httpSession = request.getSession();
        Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
        if(loginCookie != null){
            UserVO userVO = userService.checkLoginBefore(loginCookie.getValue());
            if(userVO != null)
                httpSession.setAttribute("login", userVO);
        }

        return true;
    }
}
