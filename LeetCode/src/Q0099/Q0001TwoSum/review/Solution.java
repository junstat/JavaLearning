package Q0099.Q0001TwoSum.review;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class Solution {
    @Test
    public void test1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        int[] expected = {0, 1};
        for (int i = 0; i < result.length; i++) {
            assertEquals(expected[i], result[i]);
        }
        int a = 4;
    }

    public int[] twoSum(int[] nums, int target) {
        // nums[i]: i
        var map = new HashMap<Integer, Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int a = nums[i], b = target - a;
            // a的下标在前还是b的下标在前
            if (map.containsKey(b)) return new int[]{map.get(b), i};
            map.put(a, i);
        }
        // return null;
        return new int[]{};
    }
}
