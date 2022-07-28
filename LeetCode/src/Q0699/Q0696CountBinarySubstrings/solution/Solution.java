package Q0699.Q0696CountBinarySubstrings.solution;

public class Solution {
    public int countBinarySubstrings(String s) {
        int pre = 0, n = s.length(), ans = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; ) {
            int j = i++;
            while (i < n && cs[i] == cs[i - 1]) ++i;
            int cnt = i - j;
            ans += Math.min(cnt, pre);
            pre = cnt;
        }
        return ans;
    }
}
