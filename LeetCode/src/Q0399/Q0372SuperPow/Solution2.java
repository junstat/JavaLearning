package Q0399.Q0372SuperPow;

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Super Pow.
public class Solution2 {
    public int superPow(int a, int[] b) {
        int p = mod(b, 1140);
        return pow(a, p, 1337);
    }

    int mod(int[] b, int m) {
        int res = 0;
        for (int val : b) {
            res = (res * 10 + val) % m;
        }
        return res;
    }

    int pow(int a, int b, int m) {
        a %= m;
        int res = 1;
        while (b > 0) {
            if (b % 2 == 0) {
                a = (a * a) % m;
                b /= 2;
            } else {
                res = (res * a) % m;
                b--;
            }
        }
        return res;
    }
}
