package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {
    //此时控制器方法所匹配的请求的请求路径位/test/hello
    @RequestMapping(
            value = {"/hello", "/abc"},
            method = {RequestMethod.GET,RequestMethod.POST},
//            params = {"username","!password","age=20"}
            headers = {"referer"}
    )
    public String hello(){
        return "success";
    }
//    @RequestMapping(
//            value = {"/hello", "/abc"},
//            method = RequestMethod.POST
//    )
//    public String hello1(){
//        return "success";
//    }
    @PutMapping(value = {"/hello", "/abc"})
    public String hello2(){
        return "success";
    }

    @RequestMapping("/a?a/test/ant")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id,@PathVariable("username") String username){
        System.out.println("id:"+id+",username:"+username);
        return "success";
    }
}
