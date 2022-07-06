package Q0299.Q0216CombinationSumIII.review;

import org.junit.Test;

import java.util.List;

/*
    [Medium]
    Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
    Only numbers 1 through 9 are used.
    Each number is used at most once.
    Return a list of all possible valid combinations. The list must not contain the same combination twice, and the
    combinations may be returned in any order.

    Example 1:
    Input: k = 3, n = 7
    Output: [[1,2,4]]
    Explanation:
    1 + 2 + 4 = 7
    There are no other valid combinations.

    Example 2:
    Input: k = 3, n = 9
    Output: [[1,2,6],[1,3,5],[2,3,4]]
    Explanation:
    1 + 2 + 6 = 9
    1 + 3 + 5 = 9
    2 + 3 + 4 = 9
    There are no other valid combinations.

    Example 3:
    Input: k = 4, n = 1
    Output: []
    Explanation: There are no valid combinations.
    Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there
    are no valid combination.
 */
public class Solution {
    @Test
    public void test1() {
        int k = 3, n = 7;
        System.out.println(combinationSum3(k, n));
    }

    @Test
    public void test2() {
        int k = 3, n = 9;
        System.out.println(combinationSum3(k, n));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        return null;
    }
}
