package Q0099.Q0057.review;

import org.junit.Test;

import java.util.Arrays;

/*
  [Medium]
  You are given an array of non-overlapping intervals intervals
  where intervals[i] = [starti, endi] represent the start and the
  end of the ith interval and intervals is sorted in ascending
  order by starti. You are also given an interval newInterval = [start, end]
  that represents the start and end of another interval.

  Insert newInterval into intervals such that intervals is still sorted
  in ascending order by starti and intervals still does not have any
  overlapping intervals (merge overlapping intervals if necessary).

  Return intervals after the insertion.

  Example 1:
  Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
  Output: [[1,5],[6,9]]

  Example 2:
  Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
  Output: [[1,2],[3,10],[12,16]]
  Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class Solution {

    @Test
    public void test1() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        return null;
    }
}
