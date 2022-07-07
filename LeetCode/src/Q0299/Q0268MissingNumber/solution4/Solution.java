package Q0299.Q0268MissingNumber.solution4;

public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int cur = 0, sum = n * (n + 1) / 2;
        for (int i : nums) cur += i;
        return sum - cur;
    }
}