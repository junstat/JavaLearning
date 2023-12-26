package com.jun.chap10_thread.section01.thread;


public class EvenNumberTest {
    public static void main(String[] args) {
        EvenNumber t1 = new EvenNumber();
        OddNumber t2 = new OddNumber();
        t1.start();
        t2.start();
    }
}

class EvenNumber extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
            }
        }
    }
}

class OddNumber extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
            }
        }
    }
}