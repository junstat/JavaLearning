package Q0099.Q0052.solution1;

public class Solution {
    boolean[] cols;
    boolean[] d1;
    boolean[] d2;
    int res = 0;

    public int totalNQueens(int n) {
        cols = new boolean[n];      // columns|
        d1 = new boolean[2 * n];    // diagonals \
        d2 = new boolean[2 * n];    // diagonals /
        dfs(0);
        return res;
    }

    void dfs(int row) {
        int n = cols.length;
        if (row == cols.length) res++;

        for (int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if (cols[col] || d1[id1] || d2[id2]) continue;

            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;
            dfs(row + 1);
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
    }
}
