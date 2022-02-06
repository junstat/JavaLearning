package Q0099.Q0001TwoSum;

// Solution 1: 两层循环穷举所有数，求和，比对target。
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((nums[i] + nums[j]) == target)
                    return new int[]{i, j};
            }
        }
        return null;
    }
}
