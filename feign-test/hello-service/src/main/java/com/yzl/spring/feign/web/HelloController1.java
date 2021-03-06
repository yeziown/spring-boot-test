package com.yzl.spring.feign.web;

import com.yzl.spring.feign.dto.User;
import com.yzl.spring.feign.service.HelloService1;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController1 implements HelloService1 {

    @Override
    public String hello(String name) {
        return "Hello1 " + name;
    }

    @Override
    public User hello(String name, Integer a) {
        return new User(name, a);
    }

    @Override
    public String hello(User user) {
        return "Hello1 " + user.getName() + ", " + user.getAge();
    }

}