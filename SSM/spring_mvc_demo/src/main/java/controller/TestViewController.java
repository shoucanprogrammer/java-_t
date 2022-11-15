package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TestViewController {
    @RequestMapping("/test/view/thymeleaf")
    public String tesThymeleafView(){
        return "success";
    }

    @RequestMapping("/test/view/forward")
    public String testInternalResourceView(){
        return "forward:/test/model";
    }
    @RequestMapping("/test/view/redirect")
    public String testInternalRedirectView(){
        return "redirect:/test/model";
    }


}
