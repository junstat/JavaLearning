package com.jun.chap13_generic.section02;

// SubOrder5是泛型类
public class SubOrder5<T, E> extends Order<T> {
    E e;

    public SubOrder5() {
    }

    public SubOrder5(T t, int orderId, E e) {
        super(t, orderId);
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}
