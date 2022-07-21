package Q0499.Q0462MinimumMovestoEqualArrayElementsII.solution2;

import java.util.Arrays;

/*
    here is the straightforward proof for this problem
    lets start with two points:
    a--------------------------------b
    the smallest moves is any point between a and b, and the number of moves is b-a
    if we addd another two points
    a--------c----------d------------b
    what's the minimum moves to make sure c and d make the smallest number of moves?
    it the same logic as a and b, which is ANY point between c and d.
    if eventually their value is between a and c or b and d, we can only make sure a c move the least, but not for c d
    so, just define two pointers and calculate the distance for each pair, add to result.
 */
public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int count = 0;
        while (i < j) {
            count += nums[j] - nums[i];
            i++;
            j--;
        }
        return count;
    }
}
