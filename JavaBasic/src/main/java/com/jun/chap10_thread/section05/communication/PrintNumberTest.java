package com.jun.chap10_thread.section05.communication;

class PrintNumber implements Runnable {
    private int number = 1;

    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            // synchronized (this) {
            synchronized (obj) {
                obj.notify();
                if (number <= 100) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + " : " + number++);
                    try {
                        // 线程一旦执行此方法，就进入等待状态， 同时，会释放对同步监视器的调用
                        obj.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else break;
            }
        }
    }
}

public class PrintNumberTest {
    public static void main(String[] args) {
        PrintNumber p = new PrintNumber();
        Thread t1 = new Thread(p, "线程1");
        Thread t2 = new Thread(p, "线程2");
        t1.start();
        t2.start();
    }
}
