package Q0099.Q0089GrayCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
    Backtracking
 */
public class Solution3 {
    @Test
    public void test1() {
        System.out.println(1 << 3 - 1);
    }

    int nums = 0;

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        backtracking(n, result);
        return result;
    }

    private void backtracking(int n, List<Integer> result) {
        if (n == 0) {
            result.add(nums);
        } else {
            backtracking(n - 1, result);
            nums ^= (1 << n - 1);  // nums = nums ^ (1 << (n - 1))
            backtracking(n - 1, result);
        }
    }
}
