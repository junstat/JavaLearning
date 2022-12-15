package Q1799.Q1785MinimumElementstoAddtoFormaGivenSum.solution;

public class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        // 数组和可能会越界
        // int sum = Arrays.stream(nums).sum();
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        double diff = Math.abs(goal - sum);
        return (int) Math.ceil(diff / limit);
    }
}
