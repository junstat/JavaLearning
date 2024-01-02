package com.jun.chap11_api.section02;

import org.junit.Test;

public class StringBufferBuilderTest {
    /**
     * （1）StringBuffer append(xx)：提供了很多的append()方法，用于进行字符串追加的方式拼接
     * （2）StringBuffer delete(int start, int end)：删除[start,end)之间字符
     * （3）StringBuffer deleteCharAt(int index)：删除[index]位置字符
     * （4）StringBuffer replace(int start, int end, String str)：替换[start,end)范围的字符序列为str
     * （5）void setCharAt(int index, char c)：替换[index]位置字符
     * （6）char charAt(int index)：查找指定index位置上的字符
     * （7）StringBuffer insert(int index, xx)：在[index]位置插入xx
     * （8）int length()：返回存储的字符数据的长度
     * （9）StringBuffer reverse()：反转
     */
    @Test
    public void test1() {
        StringBuilder builder = new StringBuilder();
        builder.append("abc").append("123").append("def");
        System.out.println(builder);
    }

    @Test
    public void test2() {
        StringBuilder builder = new StringBuilder("hello");
        builder.insert(2, 1).insert(2, "abc");
        System.out.println(builder);

        StringBuilder builder1 = builder.reverse();
        System.out.println(builder1);

        System.out.println(builder == builder1);
        System.out.println(builder.length());
    }

    @Test
    public void test3() {
        StringBuilder builder = new StringBuilder("hello");
        builder.setLength(2);
        System.out.println(builder);

        builder.append('c');
        System.out.println(builder);

        builder.setLength(10);
        System.out.println(builder);
        System.out.println(builder.charAt(6) == 0); // true
    }

    // 测试String、StringBuffer、StringBuilder在操作数据方面的效率
    @Test
    public void test4() {
        // 初始设置
        long startTime = 0L;
        long endTime = 0L;

        String text = "";
        StringBuilder builder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();

        // 开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }
}
