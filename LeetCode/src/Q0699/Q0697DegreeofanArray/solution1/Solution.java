package Q0699.Q0697DegreeofanArray.solution1;

import java.util.Arrays;

public class Solution {
    int N = 50009;

    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[N];
        int[] first = new int[N], last = new int[N];
        Arrays.fill(first, -1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            max = Math.max(max, ++cnt[t]);
            if (first[t] == -1) first[t] = i;
            last[t] = i;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            if (cnt[t] == max) ans = Math.min(ans, last[t] - first[t] + 1);
        }
        return ans;
    }
}