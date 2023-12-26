package com.jun.chap10_thread.section03.notsafe;

public class WindowTest1 {
    public static void main(String[] args) {
        SaleTicket1 t1 = new SaleTicket1();
        SaleTicket1 t2 = new SaleTicket1();
        SaleTicket1 t3 = new SaleTicket1();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}

class SaleTicket1 extends Thread {
    static int ticket = 100;

    @Override
    public void run() {
        while (true) {
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
