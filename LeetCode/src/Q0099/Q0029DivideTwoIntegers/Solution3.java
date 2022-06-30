package Q0099.Q0029DivideTwoIntegers;

public class Solution3 {
    int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;
    int LIMIT = MIN / 2; // MIN 的一半

    public int divide(int a, int b) {
        // 需要计算的是 a / b
        if (a == MIN && b == -1) return MAX;
        boolean negative = (a > 0 && b < 0) || (a < 0 && b > 0);
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int ans = 0;
        while (a <= b) { // a,b都被映射到了负数，a <= b 即绝对值 a >= b
            int c = b, d = -1;
            while (c >= LIMIT && d >= LIMIT && c >= a - c) {
                c += c;
                d += d;
            }
            a -= c;
            ans += d;
        }
        return negative ? ans : -ans;
    }
}