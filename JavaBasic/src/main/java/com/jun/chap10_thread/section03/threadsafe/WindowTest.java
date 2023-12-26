package com.jun.chap10_thread.section03.threadsafe;

public class WindowTest {
    public static void main(String[] args) {
        SaleTicket t1 = new SaleTicket();
        SaleTicket t2 = new SaleTicket();
        SaleTicket t3 = new SaleTicket();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}

class SaleTicket extends Thread {
    static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (SaleTicket.class) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + " -> No. " + ticket--);
                } else {
                    break;
                }
            }
        }
    }
}
