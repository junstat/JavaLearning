package Q1699.Q1684CounttheNumberofConsistentStrings.solution2;

public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int hash = 0, ans = 0;
        for (char c : allowed.toCharArray()) hash |= (1 << (c - 'a'));
        out:
        for (String s : words) {
            for (char c : s.toCharArray()) {
                if (((hash >> (c - 'a')) & 1) == 0) continue out;
            }
            ans++;
        }
        return ans;
    }
}