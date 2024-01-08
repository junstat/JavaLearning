package com.jun.chap13_generic.section03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    @Test
    public void test1() {
        // 1.
        Object obj = null;
        String str = "AA";

        obj = str;  // 基于继承的多态的使用

        // 2.
        Object[] arr = null;
        String[] arr1 = null;

        arr = arr1;  // 基于继承的多态的使用
    }

    @Test
    public void test2() {
        ArrayList<Object> list1 = null;
        ArrayList<String> list2 = null;

        // list1 = list2;
        // 反证法:
        // 假设list1 = list2允许的
        // list2.add("AA");
        // list1.add(123);
        // String str = list2.get(1); 错误的 预期是String类型，但是得到的是123

        method(list1);
        // method(list2);  // 错误的
    }

    @Test
    public void test3() {
        Person<Object> per = null;
        Person<String> per1 = null;

        // per = per1;
    }

    @Test
    public void test4() {
        List<String> list1 = null;
        ArrayList<String> list2 = new ArrayList<>();

        list1 = list2;
        list1.add("AA");
        method(list2);
    }

    public void method(ArrayList<Object> list) {

    }

    public void method(List<String> list) {

    }
}
