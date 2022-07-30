package Q0799.Q0733FloodFill.solution;

public class Solution {
    int[][] image;
    int m, n, color, newColor;

    public int[][] floodFill(int[][] _image, int sr, int sc, int _newColor) {
        image = _image;
        m = image.length;
        n = image[0].length;
        color = image[sr][sc];
        newColor = _newColor;
        if (color == newColor) return image;
        dfs(sr, sc);
        return image;
    }

    void dfs(int sr, int sc) {
        if (sr < 0 || sr >= m || sc < 0 || sc >= n || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        dfs(sr + 1, sc);
        dfs(sr - 1, sc);
        dfs(sr, sc + 1);
        dfs(sr, sc - 1);
    }
}