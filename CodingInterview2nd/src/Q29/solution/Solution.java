package Q29.solution;

import java.util.ArrayList;

public class Solution {
    ArrayList<Integer> ans = new ArrayList<>();
    int[][] mat;

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        mat = matrix;
        int m = mat.length, n = mat[0].length;
        circle(0, 0, m - 1, n - 1);
        return ans;
    }

    void circle(int x1, int y1, int x2, int y2) {
        if (x2 < x1 || y2 < y1) return;

        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) ans.add(mat[x1][i]);
            return;
        }
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++) ans.add(mat[i][y2]);
            return;
        }
        for (int i = y1; i < y2; i++) ans.add(mat[x1][i]);
        for (int i = x1; i < x2; i++) ans.add(mat[i][y2]);
        for (int i = y2; i > y1; i--) ans.add(mat[x2][i]);
        for (int i = x2; i > x1; i--) ans.add(mat[i][y1]);
        circle(x1 + 1, y1 + 1, x2 - 1, y2 - 1);
    }
}
