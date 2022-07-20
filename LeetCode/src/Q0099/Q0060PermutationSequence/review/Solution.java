package Q0099.Q0060PermutationSequence.review;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/*
    [Hard]
    The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
    By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
    1、"123"
    2、"132"
    3、"213"
    4、"231"
    5、"312"
    6、"321"
    Given n and k, return the kth permutation sequence.

    Example 1:
    Input: n = 3, k = 3
    Output: "213"

    Example 2:
    Input: n = 4, k = 9
    Output: "2314"

    Example 3:
    Input: n = 3, k = 1
    Output: "123"
 */
public class Solution {

    @Test
    public void test1() {
        assertEquals("213", getPermutation(3, 3));
    }

    public String getPermutation(int n, int k) {

        return null;
    }
}
