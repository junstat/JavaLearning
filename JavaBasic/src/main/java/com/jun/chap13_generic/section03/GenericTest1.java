package com.jun.chap13_generic.section03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest1 {
    // 测试通配符?的使用
    @Test
    public void test1() {
        List<?> list = null;
        List<Object> list1 = null;
        List<String> list2 = null;

        list = list1;
        list = list2;

        method(list1);
        method(list2);

    }

    public void method(List<?> list) {
        list.forEach(System.out::println);
        // list.add("AA"); // 错误的
    }

    @Test
    public void test2() {
        List<?> list = null;
        List<String> list1 = new ArrayList<>();

        list1.add("AA");
        list = list1;

        // 读取数据(以集合为例说明)
        Object obj = list.get(0);
        System.out.println(obj);

        // 写入数据, 操作失败
        // list.add("BB");
        // 特例: 可以将null写入集合
        list.add(null);
    }

    // 测试: 有限制条件的通配符的使用
    // ? extends A: <= A   (-inf, A]
    // ? super A: >= A
    @Test
    public void test3() {
        List<? extends Father> list = new ArrayList<>();
        List<Object> list1 = null;
        List<Father> list2 = null;
        List<Son> list3 = null;

        // list = list1;  //
        list = list2;
        list = list3;
    }

    // 针对于 ? extends A的读写
    // (-inf, A]
    @Test
    public void test3_1() {
        List<? extends Father> list = null;
        List<Father> list1 = new ArrayList<>();
        list1.add(new Father());
        list = list1;
        // 读取数据: 可以的
        Father father = list.get(0);

        // 写数据: 不可以的。例外: null
        list.add(null);
        // list.add(new Father());
        // list.add(new Son());
    }

    @Test
    public void test4() {
        List<? super Father> list = new ArrayList<>();
        List<Object> list1 = null;
        List<Father> list2 = null;
        List<Son> list3 = null;

        list = list1;
        list = list2;
        // list = list3;
    }

    @Test
    public void test4_1() {
        List<? super Father> list = null;
        List<Father> list1 = new ArrayList<>();
        list1.add(new Father());
        list = list1;

        // 读取数据: 可以的
        Object object = list.get(0);

        // 写入数据: 可以将Father及其之类的对象添加进来
        list.add(null);
        // list.add(new Object());
        list.add(new Father());
        list.add(new Son());
    }
}
