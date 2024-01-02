package com.jun.chap13_generic.section01.exer1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    // 按照生日从小到大排序
    @Override
    public int compareTo(MyDate o) {
        int yearDistance = Integer.compare(this.getYear(), o.getYear());
        if (yearDistance != 0) return yearDistance;
        int monthDistance = Integer.compare(this.getMonth(), o.getMonth());
        if (monthDistance != 0) return monthDistance;
        return Integer.compare(this.getDay(), o.getDay());
    }
}
