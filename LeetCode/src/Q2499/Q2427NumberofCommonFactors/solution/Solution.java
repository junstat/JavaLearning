package Q2499.Q2427NumberofCommonFactors.solution;

public class Solution {
    public int commonFactors(int a, int b) {
        int ans = 1;
        for (int n = 2; n <= gcd(a, b); n++)
            ans += a % n == 0 && b % n == 0 ? 1 : 0;
        return ans;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
