package Q0199.Q0118PascalsTriangle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/*
    [Easy]
    Given an integer numRows, return the first numRows of Pascal's triangle.
    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

    Example 1:
    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

    Example 2:
    Input: numRows = 1
    Output: [[1]]
 */
public class Review {
    @Test
    public void test1() {
        List<List<Integer>> result = generate(5);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Collections.singletonList(1)));
        expected.add(new ArrayList<>(Arrays.asList(1, 1)));
        expected.add(new ArrayList<>(Arrays.asList(1, 2, 1)));
        expected.add(new ArrayList<>(Arrays.asList(1, 3, 3, 1)));
        expected.add(new ArrayList<>(Arrays.asList(1, 4, 6, 4, 1)));
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                assertEquals(expected.get(i).get(j), result.get(i).get(j));
            }
        }
    }

    public List<List<Integer>> generate(int numRows) {
        return null;
    }
}
