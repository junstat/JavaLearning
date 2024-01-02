package com.jun.chap13_generic.section01.exer1;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class EmployeeTest {
    // 需求1: 按name排序
    @Test
    public void test1() {
        TreeSet<Employee> set = new TreeSet<>();

        Employee e1 = new Employee("HanMeimei", 18, new MyDate(1998, 12, 21));
        Employee e2 = new Employee("LiLei", 20, new MyDate(1996, 11, 21));
        Employee e3 = new Employee("LiHua", 21, new MyDate(2000, 9, 12));
        Employee e4 = new Employee("ZhangLei", 19, new MyDate(1997, 5, 31));
        Employee e5 = new Employee("ZhangYi", 23, new MyDate(2001, 11, 2));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        set.forEach(System.out::println);
    }

    // 需求2: 创建TreeSet时传入Comparator对象，按生日日期的先后排序。
    @Test
    public void test2() {
        TreeSet<Employee> set = new TreeSet<>(Comparator.comparing(Employee::getBirthday));

        Employee e1 = new Employee("HanMeimei", 18, new MyDate(1998, 12, 21));
        Employee e2 = new Employee("LiLei", 20, new MyDate(1996, 11, 21));
        Employee e3 = new Employee("LiHua", 21, new MyDate(2000, 9, 12));
        Employee e4 = new Employee("ZhangLei", 19, new MyDate(1996, 5, 31));
        Employee e5 = new Employee("ZhangYi", 23, new MyDate(2000, 9, 2));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        set.forEach(System.out::println);
    }
}
