package Q0099.Q0056MergeIntervals;

import org.junit.Test;

import java.util.Arrays;

/*
  [Medium]
  Given an array of intervals where intervals[i] = [starti, endi],
  merge all overlapping intervals, and return an array of the
  non-overlapping intervals that cover all the intervals in the input.

  Example 1:
  Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
  Output: [[1,6],[8,10],[15,18]]
  Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

  Example 2:
  Input: intervals = [[1,4],[4,5]]
  Output: [[1,5]]
  Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class Review {
    @Test
    public void test1() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public int[][] merge(int[][] intervals) {

        return null;
    }
}
