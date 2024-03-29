package Q0099.Q0050.review;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
  [Medium]
  Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).

  Example 1:
  Input: x = 2.00000, n = 10
  Output: 1024.00000

  Example 2:
  Input: x = 2.10000, n = 3
  Output: 9.26100

  Example 3:
  Input: x = 2.00000, n = -2
  Output: 0.25000
  Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class Review {
    @Test
    public void test1() {
        double x = 2.00000;
        int n = 10;
        assertEquals(1024.0, myPow(x, n));
    }

    public double myPow(double x, int n) {

        return 0;
    }
}
