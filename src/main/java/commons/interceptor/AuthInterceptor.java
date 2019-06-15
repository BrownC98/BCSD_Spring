package commons.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import user.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor  extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession httpSession = request.getSession();

        if(httpSession.getAttribute("login") == null) {
            response.sendRedirect("/user/login");
            return false;
        }

        return true;
    }

    //페이지 요청 정보 저장
    private void saveDestination(HttpServletRequest request){
        String uri = request.getRequestURI();
        String query = request.getQueryString();

        if(query == null || query.equals("null")){
            query = "";
        }else{
            query = "?" + query;
        }

        if(request.getMethod().equals("GET")){
            request.getSession().setAttribute("destination", uri + query);
        }
    }
}
