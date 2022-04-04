package Q0099.Q0077Combinations;

import org.junit.Test;

import java.util.List;

/*
    [Medium]
    Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
    You may return the answer in any order.

    Example 1:
    Input: n = 4, k = 2
    Output:
    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]

    Example 2:
    Input: n = 1, k = 1
    Output: [[1]]
 */
public class Review {
    @Test
    public void test1() {
        int n = 4;
        int k = 2;
        List<List<Integer>> result = combine(n, k);
        System.out.println(result);
    }

    public List<List<Integer>> combine(int n, int k) {

        return null;
    }
}
