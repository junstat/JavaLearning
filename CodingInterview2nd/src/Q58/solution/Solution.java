package Q58.solution;

public class Solution {
    public String LeftRotateString(String ss, int k) {
        if (ss == null || ss.length() == 0) return "";
        int n = ss.length();
        k %= n;
        char[] cs = ss.toCharArray();
        reverse(cs, 0, n - 1);
        reverse(cs, 0, n - k - 1);
        reverse(cs, n - k, n - 1);
        return new String(cs);
    }

    void reverse(char[] cs, int l, int r) {
        while (l < r) {
            char c = cs[l];
            cs[l++] = cs[r];
            cs[r--] = c;
        }
    }
}