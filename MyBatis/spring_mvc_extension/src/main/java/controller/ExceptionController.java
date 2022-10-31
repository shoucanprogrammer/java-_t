package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//将当前类标识为异常处理得组件
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public  String handleException(Throwable ex, Model model){
        model.addAttribute("ex",ex);
        return "error";
    }
}
