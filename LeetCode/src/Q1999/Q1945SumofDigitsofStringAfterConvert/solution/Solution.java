package Q1999.Q1945SumofDigitsofStringAfterConvert.solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution {

    @Test
    public void test1() {
        String s = "iiii";
        int k = 1;
        assertEquals(36, getLucky(s, k));
    }

    @Test
    public void test2() {
        String s = "leetcode";
        int k = 2;
        assertEquals(6, getLucky(s, k));
    }

    public int getLucky(String s, int k) {
        char[] cs = s.toCharArray();
        int ans = 0, cur = 0;
        for (char c : cs) {
            int num = c - 'a' + 1;
            while (num > 0) {
                ans += num % 10;
                num /= 10;
            }
        }
        for (int i = 1; i < k; i++) {
            cur = 0;
            while (ans > 0) {
                cur += ans % 10;
                ans /= 10;
            }
            ans = cur;
        }
        return ans;
    }
}
