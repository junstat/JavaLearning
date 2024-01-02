package com.jun.chap11_api.section04;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    @Test
    public void test1() {
        Product[] arr = new Product[5];
        arr[0] = new Product("HuaweiMate50pro", 6299);
        arr[1] = new Product("Xiaomi13pro", 4999);
        arr[2] = new Product("VivoX90pro", 5999);
        arr[3] = new Product("Iphone14ProMax", 9999);
        arr[4] = new Product("HonorMagic4", 6299);

        // 按价格从高到低排序
        Arrays.sort(arr, (a, b) -> -Double.compare(a.getPrice(), b.getPrice()));
        Arrays.stream(arr).forEach(System.out::println);

        System.out.println("-----------------------------------------------");
        // 按name从小到大排序
        Arrays.sort(arr, Comparator.comparing(Product::getName));
        Arrays.stream(arr).forEach(System.out::println);
    }

    @Test
    public void test2() {
        String[] arr = new String[]{"Tom", "Jerry", "Tony", "Rose", "Jack", "Lucy"};
        Arrays.sort(arr, (a, b) -> -a.compareTo(b));
        Arrays.stream(arr).forEach(System.out::println);
    }
}
