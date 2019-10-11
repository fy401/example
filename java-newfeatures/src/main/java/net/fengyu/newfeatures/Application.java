package net.fengyu.newfeatures;

import net.fengyu.newfeatures.service.HelloService;
import net.fengyu.newfeatures.service.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;


@SpringBootApplication
public class Application
{


//    private final HelloService helloService;
//
//
//    private final StreamService streamService;
//
//    public Application(HelloService helloService,StreamService streamService) {
//        this.helloService = helloService;
//        this.streamService = streamService;
//    }

    public static void main( String[] args )
    {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.CONSOLE);
        app.addListeners(new MainBusiListeners());
        app.run(args);
//        SpringApplication.run(Application.class, args);

//        ApplicationContext ctx = ApplicationContextUtils.getContext();
//
//        System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }


}
