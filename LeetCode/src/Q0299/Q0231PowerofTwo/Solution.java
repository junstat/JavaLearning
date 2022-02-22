package Q0299.Q0231PowerofTwo;

/*
    Power of 2 means only one bit of n is '1', so use the trick n&(n-1) == 0 to judge whether that is the case.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}