package Q0199.Q0172FactorialTrailingZeroes;

/*
    Iteration
 */
public class Solution2 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            n = n / 5;
            res += n;
        }
        return res;
    }
}
