package com.jun.chap11_api.section03.exer1;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exercise01 {
    // 练习: 将一个java.util.Date 对象转换成 java.sql.Data
    @Test
    public void test1() {
        Date date1 = new Date();
        java.sql.Date date2 = new java.sql.Date(date1.getTime());
        System.out.println(date2);
    }

    /**
     * 拓展：
     * 将控制台获取的年月日（比如：2022-12-13）的字符串数据，保存在数据库中。
     * （简化为得到java.sql.Date的对象，此对象对应的时间为2022-12-13）。
     * 字符串 ---> java.util.Date ---> java.sql.Date
     */
    @Test
    public void test2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String input = "2022-12-23";
        Date date1 = sdf.parse(input);
        java.sql.Date date2 = new java.sql.Date(date1.getTime());
        System.out.println(date2);
    }
}
