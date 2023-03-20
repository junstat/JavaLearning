package Q1899.Q1833MaximumIceCreamBars.solution;

import java.util.Arrays;

public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        var n = costs.length;
        Arrays.sort(costs);
        int ans = 0;
        for (int cost : costs) {
            if (coins >= cost) {
                ans++;
                coins -= cost;
            }
        }
        return ans;
    }
}
