package Q0399.Q0377CombinationSumIV.solution1;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) return 1;
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += combinationSum4(nums, target - num);
            }
        }
        return res;
    }
}
