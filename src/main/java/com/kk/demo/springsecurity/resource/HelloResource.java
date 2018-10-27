package com.kk.demo.springsecurity.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //结合了@Controller和@ResponseBody两个注解
@RequestMapping("/rest/hello") //定義请求的URL
public class HelloResource {

    @GetMapping //是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写
    public String hello() {
        return "Hello world";
    }
}
