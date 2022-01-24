package Q0199.Q0128LongestConsecutiveSequence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    [Medium]
    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    You must write an algorithm that runs in O(n) time.

    Example 1:
    Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

    Example 2:
    Input: nums = [0,3,7,2,5,8,4,6,0,1]
    Output: 9
 */
public class Review {

    @Test
    public void test1() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        assertEquals(longestConsecutive(nums), 4);
    }

    @Test
    public void test2() {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        assertEquals(longestConsecutive(nums), 9);
    }

    public int longestConsecutive(int[] nums) {

        return 0;
    }
}
