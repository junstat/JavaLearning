package Q0199.Q0174DungeonGame.solution1;

/*
    DP
    We cannot determines the health without knowing how much health loss is waiting for us in the future. Thus we
    need to consider from the opposite way. i.e. from destination to start position.

    First we need to know what's the min health we need at the princess location?
    The key is assuming we have M[m - 1][n - 1] health when we reach dungeon[m - 1][n - 1] before fighting, then
      1.1 we must have at least 1 blood, i.e. M[m - 1][n - 1] >= 1
      1.2 after we fight with demons, we need to have at least 1 blood to be alive,
      i.e. M[m - 1][n - 1] + dungeon[m - 1][n - 1] >= 1
    With above, we have: M[m - 1][n - 1] >= 1 and M[m - 1][n - 1] >= 1 - dungeon[i][j],
     thus M[m - 1][n - 1] >= max(1, 1 - dungeon[m - 1][n - 1])

    Then what about the previous min health we should have, let's denote cur min health as cur?
      2.1 we must have at least 1 blood, i.e. prev >= 1
      2.2 after we fight with demons, we have cur health, i.e. prev + dungeon[prev] = cur
    From above, we have prev >= 1 and prev >= cur - dungeon[prev], thus prev = max(1, cur - dungeon[prev])
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;

        int m = dungeon.length;
        int n = dungeon[0].length;

        // 1. 状态定义, health[i][j] represents the health when the knight reach dungeon[i][j]
        int[][] health = new int[m][n];
        // 2. 初始状态
        health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

        for (int i = m - 2; i >= 0; i--)
            health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);

        for (int j = n - 2; j >= 0; j--)
            health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);

        // 3. 状态转移方程
        // health[i][j] = min(max(health[i][j + 1] - dungeon[i][j], 1), max(health[i + 1][j] - dungeon[i][j], 1))
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                health[i][j] = Math.min(right, down);
            }
        }
        return health[0][0];
    }
}
