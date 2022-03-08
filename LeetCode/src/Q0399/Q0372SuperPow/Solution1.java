package Q0399.Q0372SuperPow;


public class Solution1 {
    private static final int mod = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * pow(a, b[i]) % mod);
            a = pow(a, 10);
        }
        return ans;
    }

    public int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if ((n & 1) == 1)
                res = (int) ((long) res * x % mod);
            x = (int) ((long) x * x % mod);
            n >>= 1;
        }
        return res;
    }
}
