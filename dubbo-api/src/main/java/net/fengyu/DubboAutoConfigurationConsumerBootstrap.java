package net.fengyu;





import net.fengyu.dubbotest.DemoService;
import net.fengyu.dubbotest.User;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;


@EnableAutoConfiguration
public class DubboAutoConfigurationConsumerBootstrap {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(url = "dubbo://127.0.0.1:12345")
    private DemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(DubboAutoConfigurationConsumerBootstrap.class).close();

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
//            logger.info(demoService.sayHello("mercyblitz"));
            try {
                logger.info(demoService.getStaff().toString());
            } catch (Exception e) {
                if(e instanceof org.apache.dubbo.rpc.RpcException) {
                    if(e.getMessage().indexOf("No enum constant") > 0) {
                        System.out.println("抓到你了");
                    }
                }



                System.out.println(e.getClass().getName());
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

                System.out.println(e.getMessage());
            }
        };
    }
}
