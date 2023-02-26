package Q1699.Q1648SellDiminishingValuedColoredBalls.solution2;

import java.util.Arrays;

public class Solution {
    public int maxProfit(int[] A, int T) {
        Arrays.sort(A);
        reverse(A);
        long mod = (long) 1e9 + 7, ans = 0, cur = A[0];
        int N = A.length, i = 0;
        while (T > 0) {
            while (i < N && A[i] == cur) ++i;
            long next = i == N ? 0 : A[i], h = cur - next, r = 0, cnt = Math.min(T, i * h);
            if (T < i * h) {
                h = T / i;
                r = T % i;
            }
            long val = cur - h;
            ans = (ans + (cur + val + 1) * h / 2 * i % mod + val * r % mod) % mod;
            T -= cnt;
            cur = next;
        }
        return (int) ans;
    }

    void reverse(int[] A) {
        for (int i = 0, j = A.length - 1; i < j; i++, j--) {
            int t = A[i];
            A[i] = A[j];
            A[j] = t;
        }
    }
}
