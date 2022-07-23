package Q17.solution;

public class Solution {
    static int[][] ans = new int[5][];

    static {
        for (int i = 0; i < 5; i++) {
            int end = 9, n = i;
            while (n-- > 0) end = 10 * end + 9;
            ans[i] = new int[end];
            for (int j = 1; j <= end; j++) ans[i][j - 1] = j;
        }
    }

    public int[] printNumbers(int n) {
        return ans[n - 1];
    }
}
