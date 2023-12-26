package com.jun.chap10_thread.section04.lock;

import java.util.concurrent.locks.ReentrantLock;

class Window extends Thread {
    static int ticket = 100;

    // 1. 创建Lock的实例，需要确保多个线程共用同一个Lock实例
    // 需要考虑将此对象声明为static
    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 2. 执行 lock方法
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + " -> " + ticket--);
                } else break;
            } finally {

                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
