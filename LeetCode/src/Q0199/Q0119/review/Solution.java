package Q0199.Q0119.review;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/*
    [Easy]
    Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

    Example 1:
    Input: rowIndex = 3
    Output: [1,3,3,1]

    Example 2:
    Input: rowIndex = 0
    Output: [1]

    Example 3:
    Input: rowIndex = 1
    Output: [1,1]
 */
public class Solution {
    @Test
    public void test1() {
        List<Integer> result = getRow(3);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 3, 3, 1));
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }

    public List<Integer> getRow(int rowIndex) {

        return null;
    }
}
