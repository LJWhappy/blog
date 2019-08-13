package com.spring.blog.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//此注解是Controller和ResponseBody的组合
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "你好!";
    }


}
