package Q1499.Q1402ReducingDishes.solution;

import java.util.Arrays;

public class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int ans = 0, sum = 0, n = satisfaction.length;
        for (int i = n - 1; i >= 0; i--) {
            sum += satisfaction[i];
            if (sum < 0) break;
            ans += sum;
        }
        return ans;
    }
}