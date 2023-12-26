package com.jun.chap10_thread.section06.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.stream.IntStream;

public class CallableTest {
    public static void main(String[] args) {
        // NumThread numThread = new NumThread();
        Callable<Integer> numThread = () -> IntStream.range(1, 100)
                .filter(a -> a % 2 == 0)
                .sum();
        FutureTask<Integer> futureTask = new FutureTask<>(numThread);
        Thread t1 = new Thread(futureTask);
        t1.start();

        try {
            Integer sum = futureTask.get();
            System.out.println("总和为: " + sum);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class NumThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
