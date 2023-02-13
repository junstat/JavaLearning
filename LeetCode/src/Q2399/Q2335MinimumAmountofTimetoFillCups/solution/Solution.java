package Q2399.Q2335MinimumAmountofTimetoFillCups.solution;

import java.util.Arrays;

public class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int x = amount[0], y = amount[1], z = amount[2];
        // if (x + y <= z) return z;
        // else {
        //     int t = x + y - z;
        //     return (t + 1) / 2 + z;
        // }
        return x + y <= z ? z : (x + y - z + 1) / 2 + z;
    }
}
