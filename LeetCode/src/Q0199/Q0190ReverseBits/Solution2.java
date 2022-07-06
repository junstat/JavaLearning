package Q0199.Q0190ReverseBits;

public class Solution2 {
    public int reverseBits(int n) {
        int ans = 0;
        int cnt = 32;
        while (cnt-- > 0) {
            ans <<= 1;
            ans += (n & 1);
            n >>= 1;
        }
        return ans;
    }
}
