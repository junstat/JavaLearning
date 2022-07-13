package Q0399.Q0368LargestDivisibleSubset.solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] A) {
        Arrays.sort(A);
        int N = A.length, last = 0;
        int[] dp = new int[N], prev = new int[N];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] % A[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[last]) last = i;
        }
        for (int i = last; i != -1; i = prev[i]) ans.add(A[i]);
        return ans;
    }
}
