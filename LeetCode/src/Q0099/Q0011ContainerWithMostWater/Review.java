package Q0099.Q0011ContainerWithMostWater;

import org.junit.Test;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static org.junit.Assert.assertEquals;

/*
   Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
   n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
   Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

    Notice that you may not slant the container.

    Example 1:
        Input: height = [1,8,6,2,5,4,8,3,7]
        Output: 49
        Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
        In this case, the max area of water (blue section) the container can contain is 49.

    Example 2:
        Input: height = [1,1]
        Output: 1
    Example 3:
        Input: height = [4,3,2,1,4]
        Output: 16

    Example 4:
        Input: height = [1,2,1]
        Output: 2

    Constraints:
        n == height.length
        2 <= n <= 3 * 10^4
        0 <= height[i] <= 3 * 10^4
 */
public class Review {

    @Test
    public void test1() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        assertEquals(maxArea(height), 49);
    }

    @Test
    public void test2() {
        int[] height = new int[]{1, 1};
        assertEquals(maxArea(height), 1);
    }

    public int maxArea(int[] height) {

        return 0;
    }
}
