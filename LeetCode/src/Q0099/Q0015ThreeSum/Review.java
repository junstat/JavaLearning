package Q0099.Q0015ThreeSum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * <p>
 * Example 2:
 * Input: nums = []
 * Output: []
 * <p>
 * Example 3:
 * Input: nums = [0]
 * Output: []
 */
public class Review {

    @Test
    public void test1() {
        List<List<Integer>> result = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-1, -1, 2));
        expected.add(Arrays.asList(-1, 0, 1));
        assertEquals(result, expected);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        return res;
    }
}
