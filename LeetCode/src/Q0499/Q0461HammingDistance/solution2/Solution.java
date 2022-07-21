package Q0499.Q0461HammingDistance.solution2;

public class Solution {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        while ((x | y) != 0) {
            int a = x & 1, b = y & 1;
            ans += a ^ b;
            x >>= 1; y >>= 1;
        }
        return ans;
    }
}