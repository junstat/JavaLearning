package com.jun.chap10_thread.section01.exercise;

public class Exercise {
    public static void main(String[] args) {
        A a = new A();
        a.start();

        B b = new B(a);
        b.start();
    }
}


class A extends Thread {
    @Override
    public void run() {
        System.out.println("线程A的run() ....");
    }
}

class B extends Thread {
    private A a;

    // public B(A a) {
    //     this.a = a;
    // }

    public B(A a) {
        super(a);
    }

    // @Override
    // public void run() {
    //     System.out.println("线程B的run() ....");
    // }
}