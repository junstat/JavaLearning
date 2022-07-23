package Q0199.Q0174DungeonGame.solution2;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        // corner case
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
                } else if (i == m - 1) {
                    dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
                } else if (j == n - 1) {
                    dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
                } else {
                    dp[i][j] = Math.min(Math.max(dp[i + 1][j] - dungeon[i][j], 1),
                            Math.max(dp[i][j + 1] - dungeon[i][j], 1));
                }
            }
        }
        return dp[0][0];
    }
}
