package com.jun.chap10_thread.section01.runnable;

public class EvenNumberTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new EvenNumber());
        Thread t2 = new Thread(new OddNumber());
        t1.start();
        t2.start();
    }
}

class OddNumber implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
            }
        }
    }
}

class EvenNumber implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
            }
        }
    }
}
