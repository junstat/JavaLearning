package Q0099.Q0089GrayCode;

import java.util.ArrayList;
import java.util.List;

/*
        n           result
        1           0000, 0001
        2           result(1), 0000 | 0010 = 0010, 0001 | 0010 = 0011

        result(n) based on result(n-1)
        when n = 3, we can get the result based on n = 2,
        (00, 01, 11, 10) -> (000, 001, 011, 010) union (100, 101, 111, 110)
        The middle two numbers only differ at their highest bit.
 */
public class Solution {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            int size = result.size();
            for (int j = size - 1; j >= 0; j--)
                result.add(result.get(j) | 1 << i);
        }
        return result;
    }
}
