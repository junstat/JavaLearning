package com.jun.chap11_api.section01.string;

import org.junit.Test;

public class StringMethodTest1 {
    /**
     * （1）boolean isEmpty()：字符串是否为空
     * （2）int length()：返回字符串的长度
     * （3）String concat(xx)：拼接
     * （4）boolean equals(Object obj)：比较字符串是否相等，区分大小写
     * （5）boolean equalsIgnoreCase(Object obj)：比较字符串是否相等，不区分大小写
     * （6）int compareTo(String other)：比较字符串大小，区分大小写，按照Unicode编码值比较大小
     * （7）int compareToIgnoreCase(String other)：比较字符串大小，不区分大小写
     * （8）String toLowerCase()：将字符串中大写字母转为小写
     * （9）String toUpperCase()：将字符串中小写字母转为大写
     * （10）String trim()：去掉字符串前后空白符
     * （11）public String intern()：结果在常量池中共享
     */
    @Test
    public void test1() {
        String s1 = "";
        String s2 = new String();
        String s3 = new String("");

        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());
        System.out.println(s3.isEmpty());

        String s4 = null;
        // System.out.println(s4.isEmpty()); // 报空指针异常

        String s5 = "hello";
        System.out.println(s5.length());
    }

    @Test
    public void test2() {
        String s1 = "hello";
        String s2 = "Hello";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abcd";
        String s4 = "adef";
        System.out.println(s3.compareTo(s4));

        String s5 = "abcd";
        String s6 = "aBcd";
        System.out.println(s5.compareTo(s6));
        System.out.println(s5.compareToIgnoreCase(s6));

        String s7 = "张ab";
        String s8 = "李cd";
        System.out.println(s7.compareTo(s8));

        String s9 = "   he llo  ";
        System.out.println(s9.trim());
    }

    /**
     * （11）boolean contains(xx)：是否包含xx
     * （12）int indexOf(xx)：从前往后找当前字符串中xx，即如果有返回第一次出现的下标，要是没有返回-1
     * （13）int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
     * （14）int lastIndexOf(xx)：从后往前找当前字符串中xx，即如果有返回最后一次出现的下标，要是没有返回-1
     * （15）int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索。
     */
    @Test
    public void test3() {
        String s1 = "haha";
        System.out.println(s1.contains("ha"));

        System.out.println(s1.indexOf("a"));
        System.out.println(s1.indexOf("ax"));
        System.out.println(s1.indexOf("a", 2));
        System.out.println(s1.lastIndexOf("a"));
        System.out.println(s1.lastIndexOf("a", 3));
    }

    /**
     * （16）String substring(int beginIndex) ：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
     * （17）String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
     */
    @Test
    public void test4() {
        String s1 = "welcome to Beijing.";
        System.out.println(s1.substring(3));
        System.out.println(s1.substring(3, 10)); // [3, 10)
    }

    /**
     * （18）char charAt(index)：返回[index]位置的字符
     * （19）char[] toCharArray()： 将此字符串转换为一个新的字符数组返回
     * （20）static String valueOf(char[] data)  ：返回指定数组中表示该字符序列的 String
     * （21）static String valueOf(char[] data, int offset, int count) ： 返回指定数组中表示该字符序列的 String
     * （22）static String copyValueOf(char[] data)： 返回指定数组中表示该字符序列的 String
     * （23）static String copyValueOf(char[] data, int offset, int count)：返回指定数组中表示该字符序列的 String
     */
    @Test
    public void test5() {
        String s1 = "welcome to Beijing.";
        System.out.println(s1.charAt(2));

        String s2 = String.valueOf(new char[]{'a', 'b', 'c'});
        String s3 = String.copyValueOf(new char[]{'a', 'b', 'c'});
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s2 == s3);

        System.out.println(s1.startsWith("wel"));
        System.out.println(s1.startsWith("wel", 5));
    }

    /**
     * （27）String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。 不支持正则。
     * （28）String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
     * （29）String replaceAll(String regex, String replacement)：使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
     * （30）String replaceFirst(String regex, String replacement)：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
     */
    @Test
    public void test6() {
        String s1 = "hello123 kk";
        String s2 = s1.replace('l', 'x');
        System.out.println(s1);
        System.out.println(s2);

        String s3 = s1.replace("ll", "yyyy");
        System.out.println(s3);

        String s4 = s1.replaceAll("\\d+", "");
        System.out.println(s4);
    }
}
