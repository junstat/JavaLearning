package com.jun.chap19_guava.utilites;

import java.util.concurrent.TimeUnit;

public class ElapseExample {
    public static void main(String[] args) throws InterruptedException {
        process("23432543");
    }

    private static void process(String orderNo) throws InterruptedException {
        System.out.printf("start process the order %s ns.\n", orderNo);
        long start = System.nanoTime();
        TimeUnit.SECONDS.sleep(1);
        System.out.printf("The order %s process successful and elapsed %d\n", orderNo, (System.nanoTime() - start));

        System.out.println();
    }
}
