package com.jun.chap11_api.section02.interview;

public class InterviewTest2 {
    static void stringReplace(String text) {
        text = text.replace('j', 'i');
    }

    static void bufferReplace(StringBuffer text) {
        text.append('C');
        text = new StringBuffer("Hello");
        text.append("World!");
    }

    public static void main(String[] args) {
        String textString = new String("java");
        StringBuffer textBuffer = new StringBuffer("java");
        stringReplace(textString);
        bufferReplace(textBuffer);

        System.out.println(textString + textBuffer); // java javaC
    }
}
