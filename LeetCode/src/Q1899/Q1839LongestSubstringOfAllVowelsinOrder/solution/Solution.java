package Q1899.Q1839LongestSubstringOfAllVowelsinOrder.solution;

public class Solution {
    public int longestBeautifulSubstring(String word) {
        if (word.length() < 5) return 0;
        char[] s = word.toCharArray();
        int ans = 0, cur = 1, cnt = 1, n = s.length;
        for (int i = 1; i < n; i++) {
            if (s[i] >= s[i - 1]) cur++;
            if (s[i] > s[i - 1]) cnt++;
            if (s[i] < s[i - 1]) {
                cur = 1;
                cnt = 1;
            }
            if (cnt == 5) ans = Math.max(ans, cur);
        }
        return ans;
    }
}