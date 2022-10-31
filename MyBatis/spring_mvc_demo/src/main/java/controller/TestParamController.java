package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestParamController {
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("");
        System.out.println("username:"+username+",password"+password);
        return "success";
    }
    @RequestMapping("/param")
    public String getParam(@RequestParam(value = "userName",
            required = false,
            defaultValue = "hello")
           String username,
           String password,
           @RequestHeader("referer") String referer,
           @CookieValue("JSESSIONID") String jsessionId
    ) {
        System.out.println("jsessionId:"+jsessionId);
        System.out.println("referer:"+referer);
        System.out.println("username:"+username+",password:"+password+"**************************************");
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }

}


