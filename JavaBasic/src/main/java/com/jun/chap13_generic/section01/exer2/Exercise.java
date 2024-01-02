package com.jun.chap13_generic.section01.exer2;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // 添加5个[0, 100)以内的随机整数
        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * (99 - 0 + 1));
            list.add(random);
        }

        // 输出5个整数
        list.forEach(System.out::println);

        // 使用集合的removeIf方法删除偶数
        list.removeIf(n -> n % 2 == 0);
        System.out.println();

        // 遍历剩下的元素
        list.forEach(System.out::println);
    }
}
