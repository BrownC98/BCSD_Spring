package commons.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {
    //일반적인 컨트롤러와 다르게 Model 을 파라미터로 사용하는 것을 지원하지 않음
    @ExceptionHandler(Exception.class)
    public ModelAndView commonException(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("/commons/common_error");
        return modelAndView;
    }
}
