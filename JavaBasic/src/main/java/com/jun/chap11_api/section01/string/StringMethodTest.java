package com.jun.chap11_api.section01.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringMethodTest {
    /**
     * String与常见的其它结构之间的转换
     * 1. String与基本数据类型、包装类之间的转换
     * 2. String与char[] 之间的转换
     * 3. String与byte[]之间的转换
     */
    @Test
    public void test2() {
        // 基本数据类型 -> String
        int num = 10;
        // 方式1:
        String s1 = num + "";
        // 方式2:
        String s2 = String.valueOf(num);

        // String -> 基本数据类型: 调用包装类的parseXxx(String str)
        String s3 = "123";
        int i1 = Integer.parseInt(s3);
    }

    // String 与 char[]之间的转换
    // 在utf-8字符集中，一个汉字占用3个字节，一个字母占用1个字节
    // 在gbk字符集中，一个汉字占用2个字节，一个字母占用1个字节
    @Test
    public void test3() {
        String str = "hello";
        // String -> char[]: 调用String的toCharArray()
        char[] cs = str.toCharArray();
        // char[] -> String: 调用String的构造器
        String str1 = new String(cs);
        System.out.println(str1); // hello
    }

    // String与byte[]之间的转换(难度)
    @Test
    public void test4() throws UnsupportedEncodingException {
        String str = "hi,中国";
        // String -> byte[]: 调用String的getBytes()
        byte[] arr = str.getBytes(); // 使用默认的字符集 utf-8
        System.out.println(Arrays.toString(arr));

        // 使用指定的字符集
        byte[] arr1 = str.getBytes("GBK");
        System.out.println(Arrays.toString(arr1));

        // byte[] -> String: 调用String的构造器
        String str1 = new String(arr);
        System.out.println(str1);
        String str2 = new String(arr1, "GBK");
        System.out.println(str2);
    }
}
