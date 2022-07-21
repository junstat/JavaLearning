package Q0499.Q0461HammingDistance.solution3;

public class Solution {
    int lowbit(int x) {
        return x & -x;
    }
    public int hammingDistance(int x, int y) {
        int ans = 0;
        for (int i = x ^ y; i > 0; i -= lowbit(i)) ans++;
        return ans;
    }
}