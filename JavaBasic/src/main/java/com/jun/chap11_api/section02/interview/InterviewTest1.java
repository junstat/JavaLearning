package com.jun.chap11_api.section02.interview;

public class InterviewTest1 {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a, b);
        System.out.println(a + "," + b); // ABx,B
    }

    static void operate(StringBuffer x, StringBuffer y) {
        x.append(y);  // AB
        y = x;
        y.append('x'); // ABx
    }
}
