package Q66.solution;

public class Solution {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) return new int[]{};
        int fact = 1, n = A.length;
        int[] ans = new int[n];
        ans[0] = fact;
        for (int i = 1; i < n; i++) {
            fact *= A[i - 1];
            ans[i] = fact;
        }
        fact = 1;
        for (int i = n - 2; i >= 0; i--) {
            fact *= A[i + 1];
            ans[i] *= fact;
        }
        return ans;
    }
}
