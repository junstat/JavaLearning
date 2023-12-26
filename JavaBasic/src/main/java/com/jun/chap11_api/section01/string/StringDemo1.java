package com.jun.chap11_api.section01.string;

import org.junit.Test;

public class StringDemo1 {
    @Test
    public void test1() {
        String s1 = "hello";
        String s2 = "hello";

        String s3 = new String("hello");
        String s4 = new String("hello");

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1 == s4); // false
        System.out.println(s3 == s4); // false

        System.out.println(s1.equals(s2)); // true
    }

    /**
     * String s = new String("hello"); 的内存解析？ 或
     * String s = new String("hello"); 在内存中创建了几个对象？
     */

    // 测试+
    @Test
    public void test4() {
        String s1 = "hello";
        String s2 = "world";

        String s3 = "helloworld";
        String s4 = "hello" + "world";
        String s5 = s1 + "world";  // 通过查看字节码文件发现调用了StringBuilder的toString() -> new String()
        String s6 = "hello" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s6); // false
        System.out.println(s5 == s7); // false

        String s8 = s5.intern(); // intern(): 返回的是字符串常量池中字面量的地址
        System.out.println(s3 == s8);
    }

}
