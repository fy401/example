package net.fengyu.newfeatures.runner;

import net.fengyu.newfeatures.service.StreamService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
@Order(value=1)
public class StreamRunner implements CommandLineRunner {

    @Resource
    private StreamService streamService;

    @Override
    public void run(String... args) throws Exception {
        streamService.parallelStream();
    }
}
