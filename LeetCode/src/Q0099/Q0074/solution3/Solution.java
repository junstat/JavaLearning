package Q0099.Q0074.solution3;

public class Solution {
    int m, n;

    public boolean searchMatrix(int[][] mat, int t) {
        m = mat.length;
        n = mat[0].length;
        int x = 0, y = n - 1;
        while (check(x, y) && mat[x][y] != t) {
            if (mat[x][y] > t) {
                y--;
            } else {
                x++;
            }
        }
        return check(x, y) && mat[x][y] == t;
    }

    boolean check(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
