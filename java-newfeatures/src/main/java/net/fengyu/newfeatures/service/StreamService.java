package net.fengyu.newfeatures.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Component
public class StreamService {


    public void parallelStream() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream()
                .forEach(System.out::println);
    }

}
