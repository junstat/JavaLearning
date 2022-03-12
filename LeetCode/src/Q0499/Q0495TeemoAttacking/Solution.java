package Q0499.Q0495TeemoAttacking;

/*
    The same idea as https://leetcode.com/problems/merge-intervals/
    Algorithm:

    1. Use two variable to record current start and end point.
    2. If the start of new interval is greater than current end, meaning NO overlapping, we can sum the current interval
     length to result and then update start and end.
    3. Otherwise just update the current end;
 */
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) return 0;

        int result = 0, start = timeSeries[0], end = timeSeries[0] + duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] > end) {
                result += end - start;
                start = timeSeries[i];
            }
            end = timeSeries[i] + duration;
        }
        result += end - start;
        return result;
    }
}