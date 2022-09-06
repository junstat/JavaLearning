package Q0699.Q0647PalindromicSubstrings.solution1;

public class Solution {
    int ans = 0, n;
    char[] s;

    public int countSubstrings(String ss) {
        if (ss == null || ss.length() == 0) return 0;
        n = ss.length();
        s = ss.toCharArray();

        for (int i = 0; i < n; i++) {
            extendPalindrome(i, i); // odd length 奇
            extendPalindrome(i, i + 1); // even length
        }
        return ans;
    }

    void extendPalindrome(int l, int r) {
        while (l >= 0 && r < n && s[l] == s[r]) {
            ans++;
            l--;
            r++;
        }
    }
}