package Q2399.Q2357MakeArrayZerobySubtractingEqualAmounts.solution;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int a : nums)
            if (a > 0)
                set.add(a);
        return set.size();
    }
}