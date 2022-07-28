package Q0699.Q0680ValidPalindromeII.solution;

public class Solution {
    static char[] cs;

    public boolean validPalindrome(String s) {
        cs = s.toCharArray();
        int n = s.length(), i = 0, j = n - 1;
        while (i < j && cs[i] == cs[j]) {
            ++i;
            --j;
        }
        if (i >= j) return true;
        return valid(i + 1, j) || valid(i, j - 1);
    }

    boolean valid(int i, int j) {
        while (i < j && cs[i] == cs[j]) {
            ++i;
            --j;
        }
        return i >= j;
    }
}