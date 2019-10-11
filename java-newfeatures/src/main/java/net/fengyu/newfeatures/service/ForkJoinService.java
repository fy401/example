package net.fengyu.newfeatures.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class ForkJoinService {

//    private final static List<Integer> sender = new ArrayList<Integer>(21000000);
//
//    private final static List<Integer> receiver = new ArrayList<>(21000000);
//    private final static List<Integer> receiver2 = new ArrayList<>(21000000);


    private final static AtomicInteger i = new AtomicInteger(0);


//    static {
//        log.info("prepare data");
//        while (i.get() < 21000000) {
//            sender.add(i.get());
//            i.incrementAndGet();
//        }
//        log.info("prepare over");
//    }


    public void run() throws ExecutionException, InterruptedException {
        int count  = 10000;
        SumTask sumTask = new SumTask(0,count);

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(sumTask);

        System.out.println(submit.get());


        int s = 0;
        for (int i = 0;i<=count;i++) {
            s +=i;
        }
        System.out.println(s);

    }


    @Slf4j
    @AllArgsConstructor
    public static class SumTask extends RecursiveTask<Integer> {

        private final static int threshold = 100;

        private int start;

        private int end;

        @Override
        protected Integer compute() {
            int sum = 0;
            if (end - start <= threshold){
                for (int i = start; i<= end; i++){
                    sum +=i;
                }
            }else {
                int middle = (start + end) / 2;
                SumTask sumTask = new SumTask(start, middle);
                SumTask sumTask1 = new SumTask(middle+1, end);
                SumTask.invokeAll(sumTask, sumTask1);
                sum = sumTask.join() + sumTask1.join();
            }
            return sum;
        }
    }
}
