package commons.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAfterInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //세션 얻어오기
        HttpSession session = request.getSession();
        if(session.getAttribute("login") != null ){
            //원래 위치로 되돌아감
            response.sendRedirect(request.getContextPath() + "/");
            return false;
        }
        return true;
    }
}
