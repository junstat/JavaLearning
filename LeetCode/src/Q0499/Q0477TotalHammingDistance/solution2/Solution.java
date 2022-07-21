package Q0499.Q0477TotalHammingDistance.solution2;

public class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for (int x = 31; x >= 0; x--) {
            int s0 = 0, s1 = 0;
            for (int u : nums) {
                if (((u >> x) & 1) == 1) {
                    s1++;
                } else {
                    s0++;
                }
            }
            ans += s0 * s1;
        }
        return ans;
    }
}