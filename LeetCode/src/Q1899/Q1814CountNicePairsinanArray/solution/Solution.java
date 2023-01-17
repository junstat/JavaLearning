package Q1899.Q1814CountNicePairsinanArray.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countNicePairs(int[] nums) {
        //nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        //nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
        int mod = (int) 1e9 + 7;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - rev(nums[i]);
            count.put(key, count.getOrDefault(key, 0) + 1);
        }
        long result = 0;
        for (int key : count.keySet()) {
            long times = count.get(key); //long，因为1 <= nums.length <= 10^5,int时time*(time-1)会溢出
            result = (result + (times) * (times - 1) / 2) % mod;
        }
        return (int) (result % mod);
    }

    private static int rev(int num) {
        int result = 0;
        while (num > 0) {
            int dig = num % 10;
            result = result * 10 + dig;
            num /= 10;
        }
        return result;
    }
}
