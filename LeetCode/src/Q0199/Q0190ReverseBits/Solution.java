package Q0199.Q0190ReverseBits;

/*
    We first intitialize result to 0. We then iterate from
    0 to 31 (an integer has 32 bits). In each iteration:
    We first shift result to the left by 1 bit.
    Then, if the last digit of input n is 1, we add 1 to result. To
    find the last digit of n, we just do: (n & 1)
    Example, if n=5 (101), n&1 = 101 & 001 = 001 = 1;
    however, if n = 2 (10), n&1 = 10 & 01 = 00 = 0).

    Finally, we update n by shifting it to the right by 1 (n >>= 1). This is because the last digit is already taken
    care of, so we need to drop it by shifting n to the right by 1.
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0) return 0;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;   // 移掉最高位
            if ((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }
}
