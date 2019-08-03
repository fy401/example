package net.fengyu.newfeatures.runner;


import net.fengyu.newfeatures.service.HelloService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Order(value=2)
public class HelloRunner  implements CommandLineRunner {

    @Resource
    private HelloService helloService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(helloService.sayHello("封宇"));
    }
}
