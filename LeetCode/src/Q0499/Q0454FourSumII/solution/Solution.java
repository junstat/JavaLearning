package Q0499.Q0454FourSumII.solution;

import java.util.HashMap;
import java.util.Map;

/*
    Count number of solutions to a + b + c + d  = 0
    ⇒ a + b = -(c + d)

    Iterate through the first 2 arrays and count the frequency of all possible sums of pairs
    Iterate through the other 2 arrays and sum up the frequency of -(c + d) where c and d are all possible pairs in
    these 2 arrays. -(c + d) should be equal to a + b for a valid solution.
    The number of such matches is the required result
 */
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> pairCountBySum = new HashMap<Integer, Integer>();
        for (int num1 : nums1)
            for (int num2 : nums2)
                pairCountBySum.compute(num1 + num2, (k, sumCount) -> sumCount == null ? 1 : ++sumCount);

        int fourSumCount = 0;
        for (int num3 : nums3)
            for (int num4 : nums4)
                fourSumCount += pairCountBySum.getOrDefault(-(num3 + num4), 0);

        return fourSumCount;
    }
}