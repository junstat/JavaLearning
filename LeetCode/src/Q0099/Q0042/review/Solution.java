package Q0099.Q0042.review;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
  [Hard]
  Given n non-negative integers representing an elevation map where the width of each bar is 1,
  compute how much water it can trap after raining.

  Example 1:
  Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
  Output: 6
  Explanation: The above elevation map (black section) is represented by array
  [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
  6 units of rain water (blue section) are being trapped.

  Example 2:
  Input: height = [4,2,0,3,2,5]
  Output: 9
 */
public class Solution {
    @Test
    public void test1() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected = 6;
        assertEquals(expected, trap(height));
    }

    public int trap(int[] height) {

        return 0;
    }
}
