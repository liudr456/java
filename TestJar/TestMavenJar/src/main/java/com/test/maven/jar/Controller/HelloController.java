package com.test.maven.jar.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("hello")
@RequestMapping("/test")
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "HelloController中的hello方法";
    }
}