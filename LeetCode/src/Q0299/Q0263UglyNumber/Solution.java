package Q0299.Q0263UglyNumber;

/*
    Just divide by 2, 3 and 5 as often as possible and then check whether we arrived at 1.
 */
public class Solution {
    public boolean isUgly(int n) {
        for (int i = 2; i < 6 && n > 0; i++) {
            while (n % i == 0)
                n /= i;
        }
        return n == 1;
    }
}
