package com.jun.chap13_generic.section01.exer1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private MyDate birthday;

    // 按照name从低到高排序
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
}
