package Q0499.Q0416PartitionEqualSubsetSum.solution1;

public class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0;
        // 「等和子集」的和必然是总和的一半
        for (int num : nums) sum += num;
        // 对应了总和为奇数的情况，注定不能被分为两个「等和子集」
        if ((sum & 1) == 1) return false;

        int target = sum / 2;
        int[][] f = new int[n][target + 1];
        // 先考虑第1件物品的情况
        for (int j = 0; j <= target; j++) f[0][j] = j >= nums[0] ? nums[0] : 0;
        // 再考虑其余物品的情况
        for (int i = 1; i < n; i++) {
            int t = nums[i];
            for (int j = 0; j <= target; j++) {
                // 不选第i件物品
                int no = f[i - 1][j];
                // 选第i件物品
                int yes = j >= t ? f[i - 1][j - t] + t : 0;
                f[i][j] = Math.max(no, yes);
            }
        }
        // 如果最大价值等于target，说明可以拆分成两个「等和子集」
        return f[n - 1][target] == target;
    }
}