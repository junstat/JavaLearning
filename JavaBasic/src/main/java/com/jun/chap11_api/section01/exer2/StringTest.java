package com.jun.chap11_api.section01.exer2;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class StringTest {

    @Test
    public void test1() {
        assertThat(myTrim("   a   "), equalTo("a"));
    }

    String myTrim(String str) {
        if (str == null || str.isEmpty())
            return str;
        int n = str.length(), start = 0, end = n - 1;
        char[] cs = str.toCharArray();
        while (start < n && cs[start] == ' ') start++;
        while (end > start && cs[end] == ' ') end--;
        return str.substring(start, end + 1);
    }

    @Test
    public void test2() {
        String s = "abcdefg";
        String ans = reverse(s, 2, 5);
        assertThat(ans, equalTo("abfedcg"));
    }

    /**
     * 题目2: 将一个字符串进行反转。将字符串指定部分反转
     * example: "abcdefg" -> "abfedcg"
     */
    public String reverse(String str, int fromIndex, int toIndex) {
        if (str == null || str.isEmpty()) return str;
        char[] cs = str.toCharArray();
        for (int i = fromIndex, j = toIndex; i < j; i++, j--) {
            char t = cs[i];
            cs[i] = cs[j];
            cs[j] = t;
        }
        return new String(cs);
    }


    /**
     * 题目3: 获取一个字符串在另一个字符串中出现的次数
     * example: "ab" 在 "abkkcadkabkebfkabkskab"中出现的次数
     */
    public int getSubStringCount(String str, String subStr) {
        int count = 0, idx = 0;

        while ((idx = str.indexOf(subStr, idx + subStr.length())) >= 0) count++;
        return count;
    }

    @Test
    public void test3() {
        String src = "abkkcadkabkebfkabkskab";
        String sub = "ab";
        int ans = getSubStringCount(src, sub);
        // System.out.println(ans);
        assertThat(ans, equalTo(3));
    }

    /**
     * 题目4: 获取两个字符串中最大相同子串。比如：
     * str1 = "abcwerthelloyuiodef";
     * str2 = "cvhellobnm"
     * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
     */
    String getMaxSameSubString(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] f = new int[m + 1][n + 1];
        int maxLen = 0, endIdx = 0;
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cs1[i - 1] == cs2[j - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    if (f[i][j] > maxLen) {
                        maxLen = f[i][j];
                        endIdx = i - 1; // 更新最长公共子串的结束位置
                    }
                } else {
                    f[i][j] = 0;
                }
            }
        }
        if (maxLen == 0) return "";
        return s1.substring(endIdx - maxLen + 1, endIdx + 1);
    }

    @Test
    public void test4() {
        String str1 = "abcwerthelloyuiodef", str2 = "cvhellobnm";
        // System.out.println(getMaxSameSubString(str1, str2));
        assertThat(getMaxSameSubString(str1, str2), equalTo("hello"));
    }

    String stringSort(String s) {
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }

    @Test
    public void test5() {
        String s = "asdhuhn";
        assertThat(stringSort(s), equalTo("adhhnsu"));
    }
}
