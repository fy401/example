package net.fengyu.newfeatures.runner;

import net.fengyu.newfeatures.service.ForkJoinService;
import org.springframework.boot.CommandLineRunner;

import javax.annotation.Resource;

//@Component
public class ForkJoinRunner implements CommandLineRunner {

    @Resource
    private ForkJoinService forkJoinService;


    @Override
    public void run(String... args) throws Exception {
        forkJoinService.run();
    }

}
