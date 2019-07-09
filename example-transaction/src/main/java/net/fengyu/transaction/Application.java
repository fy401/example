package net.fengyu.transaction;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hello world!
 *
 */

@EnableTransactionManagement
@SpringBootApplication
//@EnableScheduling
public class Application
{

    //放开这里，单元测试会报错，原因暂时不清
    /*
    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }*/

    public static void main( String[] args )
    {
//        SpringApplication.run(Application.class,args);
//        System.out.println( "Hello World!" );

        SpringApplication application = new SpringApplication(Application.class);

        application.setBannerMode(Banner.Mode.CONSOLE);

        application.run(args);
    }
}
