package Q1299.Q1276;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    @Test
    public void test1() {
        System.out.println(numOfBurgers(4, 17));
        System.out.println(numOfBurgers(17, 4));
    }

    public List<Integer> numOfBurgers(int a, int b) {
        if (a % 2 != 0 || a / 2 < b || 2 * b < a / 2)
            return Collections.emptyList();
        return Arrays.asList(a / 2 - b, 2 * b - a / 2);
    }
}
