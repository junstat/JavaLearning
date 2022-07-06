package Q0199.Q0191Numberof1Bits;

public class Solution3 {
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = n; i != 0; i -= lowbit(i)) ans++;
        return ans;
    }

    int lowbit(int x) {
        return x & -x;
    }
}