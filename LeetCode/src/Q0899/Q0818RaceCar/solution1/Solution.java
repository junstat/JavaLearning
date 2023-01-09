package Q0899.Q0818RaceCar.solution1;

public class Solution {
    // 动态规划 + 数学
    public static int racecar(int target) {
        int[] dp = new int[target + 1];
        return process(target, dp);
    }

    public static int process(int target, int[] dp) {
        if (dp[target] > 0) {
            return dp[target];
        }
        int steps = 0;
        int speed = 1;
        while (speed <= target) {
            speed <<= 1;
            steps++;
        }
        int ans = 0;
        int beyond = speed - 1 - target;
        if (beyond == 0) {
            ans = steps;
        } else {
            ans = steps + 1 + process(beyond, dp);
            steps--;
            speed >>= 1;
            int lack = target - (speed - 1);
            int offset = 1;
            for (int back = 0; back < steps; back++) {
                ans = Math.min(ans, steps + 1 + back + 1 + process(lack, dp));
                lack += offset;
                offset <<= 1;
            }
        }
        dp[target] = ans;
        return ans;
    }
}