package Q0099.Q0054.solution1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> ans = new ArrayList<>();
    int[][] mat;

    public List<Integer> spiralOrder(int[][] _mat) {
        mat = _mat;
        int m = mat.length, n = mat[0].length;
        circle(0, 0, m - 1, n - 1);
        return ans;
    }

    // 遍历 以 (x1, y1) 作为左上角，(x2, y2) 作为右下角形成的「圈」
    void circle(int x1, int y1, int x2, int y2) {
        if (x2 < x1 || y2 < y1) return;
        // 只有一行时，按「行」遍历
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) ans.add(mat[x1][i]);
            return;
        }
        // 只有一列时，按「列」遍历
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++) ans.add(mat[i][y2]);
            return;
        }
        // 遍历当前「圈」
        for (int i = y1; i < y2; i++) ans.add(mat[x1][i]);
        for (int i = x1; i < x2; i++) ans.add(mat[i][y2]);
        for (int i = y2; i > y1; i--) ans.add(mat[x2][i]);
        for (int i = x2; i > x1; i--) ans.add(mat[i][y1]);
        // 往里收一圈，继续遍历
        circle(x1 + 1, y1 + 1, x2 - 1, y2 - 1);
    }
}
