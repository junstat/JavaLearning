package Q0399.Q0371SumofTwoIntegers;

/*
    A summary: how to use bit manipulation to solve problems easily and efficiently
    https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary%3A-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
 */
public class Solution1 {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
