package Q0399.Q0352DataStreamasDisjointIntervals;

/*
    [Hard]
    Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a list
    of disjoint intervals.

    Implement the SummaryRanges class:

        SummaryRanges() Initializes the object with an empty stream.
        void addNum(int val) Adds the integer val to the stream.
        int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint
        intervals [starti, endi].

    Example 1:
    Input
    ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
    [[], [1], [], [3], [], [7], [], [2], [], [6], []]
    Output
    [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]

    Explanation
    SummaryRanges summaryRanges = new SummaryRanges();
    summaryRanges.addNum(1);      // arr = [1]
    summaryRanges.getIntervals(); // return [[1, 1]]
    summaryRanges.addNum(3);      // arr = [1, 3]
    summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
    summaryRanges.addNum(7);      // arr = [1, 3, 7]
    summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
    summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
    summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
    summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
    summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
 */
public class Review {

}

class SummaryRangesReview {

    public SummaryRangesReview() {

    }

    public void addNum(int val) {

    }

    public int[][] getIntervals() {

        return null;
    }
}