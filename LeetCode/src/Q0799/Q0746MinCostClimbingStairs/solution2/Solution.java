package Q0799.Q0746MinCostClimbingStairs.solution2;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int pre = cost[0], cur = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int next = cost[i] + Math.min(pre, cur);
            pre = cur;
            cur = next;
        }
        return Math.min(pre, cur);
    }
}
