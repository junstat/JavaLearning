package Q0899.Q0853CarFleet;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length, ans = 0;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++)
            cars[i] = new double[]{position[i], (double) (target - position[i]) / speed[i]};
        Arrays.sort(cars, Comparator.comparingDouble(a -> a[0]));
        double cur = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (cars[i][1] > cur) {
                cur = cars[i][1];
                ans++;
            }
        }
        return ans;
    }
}
