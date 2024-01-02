package Q0099.Q0046.review;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/*
    [Medium]
    Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any
    order.

    Example 1:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    Example 2:
    Input: nums = [0,1]
    Output: [[0,1],[1,0]]

    Example 3:
    Input: nums = [1]
    Output: [[1]]
 */
public class Solution {
    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 2, 3));
        expected.add(Arrays.asList(1, 3, 2));
        expected.add(Arrays.asList(2, 1, 3));
        expected.add(Arrays.asList(2, 3, 1));
        expected.add(Arrays.asList(3, 1, 2));
        expected.add(Arrays.asList(3, 2, 1));
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                assertEquals(expected.get(i).get(j), result.get(i).get(j));
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        return null;
    }
}
