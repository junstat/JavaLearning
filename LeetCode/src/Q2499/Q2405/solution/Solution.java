package Q2499.Q2405.solution;

public class Solution {
    public int partitionString(String ss) {
        int seen = 0, ans = 1;
        char[] s = ss.toCharArray();
        for (char c : s) {
            int val = c - 'a';
            if ((seen & (1 << val)) != 0) {
                seen = 0;
                ans++;
            }
            seen = seen | (1 << val);
        }
        return ans;
    }
}
