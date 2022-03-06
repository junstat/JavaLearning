package Q0399.Q0338CountingBits;

/*
    An easy recurrence for this problem is f[i] = f[i / 2] + i % 2
    Take number X for example, 10011001.
    Divide it in 2 parts:
    <1>the last digit ( 1 or 0, which is " i&1 ", equivalent to " i%2 " )
    <2>the other digits ( the number of 1, which is " f[i >> 1] ", equivalent to " f[i/2] " )
 */
public class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++)
            result[i] = result[i >> 1] + (i & 1);
        return result;
    }
}
