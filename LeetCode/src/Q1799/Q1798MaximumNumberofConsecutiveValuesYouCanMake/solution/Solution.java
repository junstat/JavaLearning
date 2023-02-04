package Q1799.Q1798MaximumNumberofConsecutiveValuesYouCanMake.solution;

import java.util.Arrays;

public class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int x = 0;
        for (int y : coins) {
            if (y > x + 1) break;
            x += y;
        }
        return x + 1;
    }
}

