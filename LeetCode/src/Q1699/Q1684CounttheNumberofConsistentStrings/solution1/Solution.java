package Q1699.Q1684CounttheNumberofConsistentStrings.solution1;

public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] hash = new boolean[26];
        for (char c : allowed.toCharArray()) hash[c - 'a'] = true;
        int ans = 0;
        out:
        for (String s : words) {
            for (char c : s.toCharArray()) {
                if (!hash[c - 'a']) continue out;
            }
            ans++;
        }
        return ans;
    }
}