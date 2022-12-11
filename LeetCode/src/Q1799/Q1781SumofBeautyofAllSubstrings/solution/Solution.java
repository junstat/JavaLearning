package Q1799.Q1781SumofBeautyofAllSubstrings.solution;

public class Solution {
    static int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;

    public int beautySum(String s) {
        int ans = 0, n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            for (int j = i; j < n; j++) {
                cnt[cs[j] - 'a'] += 1;
                int maxValue = MIN, minValue = MAX;
                for (int val : cnt) {
                    if (val <= 0) {
                        continue;
                    }
                    if (val > maxValue) {
                        maxValue = val;
                    }
                    if (val < minValue) {
                        minValue = val;
                    }
                }
                ans += (maxValue - minValue);
            }
        }
        return ans;
    }
}
