package com.jun.chap13_generic.section02.exer3;

import org.junit.Test;

public class StudentTest {
    @Test
    public void test1() {
        Student<String> s1 = new Student<>("Tom","良好");

        Student<Double> s2 = new Student<>("Jerry",87.5);//87.5自动装箱

        Student<Character> s3 = new Student<>("Rose",'A');//'A'自动装箱


        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
