package Q0499.Q0409LongestPalindrome.solution;

public class Solution {
    public int longestPalindrome(String s) {
        int n = 'z' - 'A' + 1;
        int[] counter = new int[n];
        for (char c : s.toCharArray()) counter[c - 'A']++;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            counter[i] = counter[i] / 2;
            ans += 2 * counter[i];
        }
        return s.length() == ans ? ans : ans + 1;
    }
}