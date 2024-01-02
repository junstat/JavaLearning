package com.jun.chap11_api.section04;

import org.junit.Test;

import java.util.Arrays;

public class ComparableTest {
    @Test
    public void test1() {
        String[] arr = new String[]{"Tom", "Jerry", "Tony", "Rose", "Jack", "Lucy"};

        Arrays.sort(arr);

        // 排序后，遍历
        Arrays.stream(arr).forEach(System.out::println);
    }

    @Test
    public void test2() {
        Product[] arr = new Product[5];
        arr[0] = new Product("HuaweiMate50pro", 6299);
        arr[1] = new Product("Xiaomi13pro", 4999);
        arr[2] = new Product("VivoX90pro", 5999);
        arr[3] = new Product("Iphone14ProMax", 9999);
        arr[4] = new Product("HonorMagic4", 6299);

        Arrays.sort(arr);
        // 排序后，遍历
        Arrays.stream(arr).forEach(System.out::println);
    }

    @Test
    public void test3() {
        Product p1 = new Product("HuaweiMate50pro", 6299);
        Product p2 = new Product("VivoX90pro", 5999);
        int compare = p1.compareTo(p2);
        if (compare > 0) {
            System.out.println("p1大");
        } else if (compare < 0) {
            System.out.println("p2大");
        } else {
            System.out.println("p1和p2一样大");
        }
    }
}
