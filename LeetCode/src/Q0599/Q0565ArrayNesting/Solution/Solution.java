package Q0599.Q0565ArrayNesting.Solution;

public class Solution {
    public int arrayNesting(int[] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == -1) continue;
            int cnt = 0, j = i;
            while (A[j] != -1) {
                int k = j;
                j = A[j];
                A[k] = -1;
                ++cnt;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
