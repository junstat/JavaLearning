package com.jun.chap11_api.section01.exer2;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LongestCommonSubstring {
    @Test
    public void test1() {
        String str1 = "ABABC";
        String str2 = "BABCBA";

        String result = findLongestCommonSubstring(str1, str2);
        assertThat(result, equalTo("BABC"));
    }

    public static String findLongestCommonSubstring(String ss, String tt) {
        String s = " " + ss, t = " " + tt;
        int m = s.length(), n = t.length();
        char[] cs = s.toCharArray(), ct = t.toCharArray();
        int[][] f = new int[m][n];
        int maxLen = 0, endIdx = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cs[i] == ct[j]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    if (f[i][j] > maxLen) {
                        maxLen = f[i][j];
                        endIdx = i;
                    }
                } else {
                    f[i][j] = 0;
                }
            }
        }
        if (maxLen == 0) return "";
        return s.substring(endIdx - maxLen + 1, endIdx + 1);
    }

}
