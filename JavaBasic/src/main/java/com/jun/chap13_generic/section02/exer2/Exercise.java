package com.jun.chap13_generic.section02.exer2;

public class Exercise {
    // 练习1: 泛型方法
    // 编写一个泛型方法，实现任意引用类型数组指定位置元素交换。
    public static <E> void method1(E[] e, int a, int b) {
        E t = e[a];
        e[a] = e[b];
        e[b] = t;
    }

    // 练习2: 泛型方法
    // 编写一个泛型方法，接收一个任意引用类型的数组，并反转数组中的所有元素
    public static <E> void method2(E[] e) {
        for (int i = 0, j = e.length - 1; i < j; i++, j--) {
            method1(e, i, j);
        }
    }
}
