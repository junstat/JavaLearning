package Q0099.Q0029DivideTwoIntegers;

public class Solution1 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean negative;
        negative = (dividend ^ divisor) < 0;   // 用异或来计算是否符号相异
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((t >> i) >= d) {
                result += 1 << i;
                t -= d << i;
            }
        }
        return negative ? -result : result;   // 符号相异取反
    }
}
