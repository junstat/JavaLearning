package Q0399.Q0354RussianDollEnvelopes;

import java.util.Arrays;
import java.util.Comparator;

/*
    1. Sort the array. Ascend on width and descend on height if width are same.
    2. Find the longest increasing subsequence based on height.

    Since the width is increasing, we only need to consider height.
    [3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] when sorting otherwise
    it will be counted as an increasing number if the order is [3, 3], [3, 4]
 */
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 ||
                envelopes[0] == null || envelopes[0].length != 2)
            return 0;

        Arrays.sort(envelopes, (arr1, arr2) -> (arr1[0] == arr2[0] ? arr2[1] - arr1[1] : arr1[0] - arr2[0]));

        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (index < 0)
                index = -(index + 1);
            dp[index] = envelope[1];
            if (index == len) len++;
        }
        return len;
    }
}
