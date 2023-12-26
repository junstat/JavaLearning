package com.jun.chap10_thread.section04.singleton;

public class BankTest {
    static Bank b1 = null;
    static Bank b2 = null;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> b1 = Bank.getInstance());
        Thread t2 = new Thread(() -> b2 = Bank.getInstance());
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1 == b2);
    }
}

class Bank {
    private Bank() {
    }

    // volatile 避免指令重排
    private static volatile Bank instance = null;

    // 方式1：
    // public static synchronized Bank getInstance() {
    //     if (instance == null) {
    //         try {
    //             Thread.sleep(1000);
    //         } catch (InterruptedException e) {
    //             throw new RuntimeException(e);
    //         }
    //         instance = new Bank();
    //     }
    //     return instance;
    // }

    // 方式2:
    // public static Bank getInstance() {
    //     synchronized (Bank.class) {
    //         if (instance == null) {
    //             try {
    //                 Thread.sleep(1000);
    //             } catch (InterruptedException e) {
    //                 throw new RuntimeException(e);
    //             }
    //             instance = new Bank();
    //         }
    //     }
    //     return instance;
    // }

    // 方式3: 相较于方式1和方式2来讲，效率更高
    // 为了避免出现指令重排，需要将instance声明为volatile
    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
