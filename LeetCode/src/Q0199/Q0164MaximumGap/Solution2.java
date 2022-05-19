package Q0199.Q0164MaximumGap;

import java.util.Arrays;

public class Solution2 {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int l = Arrays.stream(nums).min().getAsInt();
        int u = Arrays.stream(nums).max().getAsInt();
        int gap = Math.max((u - l) / (n - 1), 1);
        int m = (u - l) / gap + 1;
        int[] bucketsMin = new int[m], bucketsMax = new int[m];
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);
        for (int num : nums) {
            int k = (num - l) / gap;
            if (num < bucketsMin[k]) bucketsMin[k] = num;
            if (num > bucketsMax[k]) bucketsMax[k] = num;
        }
        int i = 0, j;
        gap = bucketsMax[0] - bucketsMin[0];
        while (i < m) {
            j = i + 1;
            while (j < m && bucketsMin[j] == Integer.MAX_VALUE && bucketsMax[j] == Integer.MIN_VALUE) j++;
            if (j == m) break;
            gap = Math.max(gap, bucketsMin[j] - bucketsMax[i]);
            i = j;
        }
        return gap;
    }
}
