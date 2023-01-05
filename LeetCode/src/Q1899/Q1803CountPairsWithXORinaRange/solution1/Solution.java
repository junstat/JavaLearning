package Q1899.Q1803CountPairsWithXORinaRange.solution1;

public class Solution {
    public int countPairs(int[] nums, int low, int high) {
        int ans = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        int[] freq = new int[20001];
        for (int num : nums) {
            freq[num]++;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        for (int j = min; j <= max; j++) {
            if (freq[j] == 0) continue;
            for (int i = low; i <= high; i++) {
                int xor = i ^ j;
                if (xor >= 1 && xor <= 20000) {
                    ans += freq[j] * freq[xor];
                }
            }
        }
        return ans >> 1;
    }
}