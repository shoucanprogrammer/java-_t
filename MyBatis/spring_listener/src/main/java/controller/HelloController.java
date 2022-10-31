package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.HelloService;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;
}
