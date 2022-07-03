package Q0199.Q0136SingleNumber;

public class Solution {
    public int singleNumber(int[] nums) {
        // 0 ^ i = i (for all i in R, i not 0)
        // i ^ i = 0 (for all i)
        int ans = 0;
        for (int num : nums) ans ^= num;
        return ans;
    }
}
