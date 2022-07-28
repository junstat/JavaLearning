package Q0699.Q0667BeautifulArrangementII.solution2;

import java.util.Arrays;

public class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int i = 1;
        for (int val = 1, diff = k, dir = 1; diff != 0; ++i) {
            val += diff * dir;
            --diff;
            dir = -dir;
            ans[i] = val;
        }
        for (int val = 2 + k; i < n; ++i, ++val) ans[i] = val;
        return ans;
    }
}
