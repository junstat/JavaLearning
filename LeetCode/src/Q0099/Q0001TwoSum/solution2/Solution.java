package Q0099.Q0001TwoSum.solution2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    @Test
    public void test1() {
        int[] nums = {0, 1, 3, 5, 4};
        int t = 8;
        System.out.println(Arrays.toString(twoSum(nums, t)));
    }

    public int[] twoSum(int[] nums, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i], b = t - a;
            if (map.containsKey(b)) return new int[]{map.get(b), i};
            map.put(a, i);
        }
        return new int[]{-1, -1};
    }
}
