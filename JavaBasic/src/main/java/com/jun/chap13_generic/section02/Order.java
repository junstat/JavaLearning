package com.jun.chap13_generic.section02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order<T> {
    // 声明类的泛型参数以后，就可以在类的内部使用此泛型参数

    T t;
    int orderId;

    // 不可以在静态方法中使用类的泛型
    // public static void method1() {
    //     System.out.println("t : " + t);
    // }

    // 自定义泛型方法
    public <E> E method(E e) {
        return null;
    }

    // 定义泛型方法，将E[]数组元素添加到对应类型的List中，并返回
    public <E> List<E> copyFromArrayToList(E[] arr) {
        return Arrays.stream(arr).toList();
    }
}
