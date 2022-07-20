package Q0099.Q0062UniquePaths.solution2;

public class Solution {
    public int uniquePaths(int rows, int cols) {
        int[] cur = new int[cols];
        int[] pre = new int[cols];

        for (int i = 0; i < cols; i++) {
            pre[i] = 1;
            cur[i] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++)
                cur[j] = cur[j - 1] + pre[j];
            pre = cur;
        }

        return cur[cols - 1];
    }
}
