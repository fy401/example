package net.fengyu.newfeatures.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component

public class HelloService {


    public String sayHello(String name) {
        return "Hello," + name;
    }
}
