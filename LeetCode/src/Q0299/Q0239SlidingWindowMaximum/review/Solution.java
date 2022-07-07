package Q0299.Q0239SlidingWindowMaximum.review;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    [Hard]
    You are given an array of integers nums, there is a sliding window of size k which is moving from the very left
    of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves
    right by one position.
    Return the max sliding window.

    Example 1:
    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
    Output: [3,3,5,5,6,7]
    Explanation:
    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7

    Example 2:
    Input: nums = [1], k = 1
    Output: [1]
 */
public class Solution {
    @Test
    public void test1() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] expected = new int[]{3, 3, 5, 5, 6, 7};
        int[] result = maxSlidingWindow(nums, k);
        for (int i = 0; i < result.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        return null;
    }
}
