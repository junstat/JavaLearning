package com.jun.chap13_generic.section02;

import org.junit.Test;

import java.util.List;

public class GenericTest {
    // 测试自定义的泛型类
    @Test
    public void test1() {
        // 实例化时，就可以指明类的泛型参数的类型
        Order order = new Order();
        Object obj = order.getT();

        // 泛型参数在指明时，是不可以使用基本数据类型的
        // 但是可以使用包装类替代基本数据类型
        // Order<int> order1 = new Order<int>();
        // 在实例化时， 可以指明类的泛型参数为具体类型
        // 一旦指明了泛型的类型，则在泛型类中凡是使用泛型
        // 参数的位置，都替换为指定的类型
        Order<Integer> order2 = new Order<>();
        Integer t = order2.getT();

        Order<String> order3 = new Order<>();
        order3.setT("AA");
    }

    // 测试Order的子类
    @Test
    public void test2() {
        // 实例化SubOrder1
        SubOrder1 sub1 = new SubOrder1();
        Object t1 = sub1.getT();

        SubOrder2 sub2 = new SubOrder2();
        Integer t2 = sub2.getT();

        SubOrder3<String> sub3 = new SubOrder3<>();
        String t3 = sub3.getT();
        sub3.show("AA");

        SubOrder4<String> sub4 = new SubOrder4<>();
        Integer t4 = sub4.getT();
        String e = sub4.getE();

        SubOrder5<String, Integer> sub5 = new SubOrder5<>();
        String t5 = sub5.getT();
        Integer e1 = sub5.getE();
    }

    // 测试泛型方法的使用
    @Test
    public void test3() {
        Order<String> order1 = new Order<>();
        Integer[] arr = {1, 2, 3, 4, 5};
        List<Integer> nums = order1.copyFromArrayToList(arr);
        System.out.println(nums);
    }

}
