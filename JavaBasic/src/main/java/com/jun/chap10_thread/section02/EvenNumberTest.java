package com.jun.chap10_thread.section02;

public class EvenNumberTest {
    public static void main(String[] args) {
        EvenNumber t1 = new EvenNumber("线程1");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);


        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
            }

            if (i == 20) {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class EvenNumber extends Thread {
    public EvenNumber() {
    }

    public EvenNumber(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++)
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + " -> " + i);
    }
}
