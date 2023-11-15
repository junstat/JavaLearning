package Q2699.Q2656MaximumSumWithExactlyKElements;

import org.junit.Test;

import java.util.Arrays;

public class Solution {

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        System.out.println(maximizeSum(nums, k));
    }

    public int maximizeSum(int[] nums, int k) {
        int mx = Arrays.stream(nums).max().getAsInt();
        return k * mx + k * (k - 1) / 2;
    }
}
