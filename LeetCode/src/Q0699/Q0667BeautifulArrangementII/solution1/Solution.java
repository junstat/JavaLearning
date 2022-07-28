package Q0699.Q0667BeautifulArrangementII.solution1;

public class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        for (int i = 0, val = 1, diff = k, dir = 1; i < n; i++) {
            ans[i] = val;
            if (diff == 0) {
                dir = 0;
                val = 2 + k;
                diff = 1; // any non-zero value
            } else if (dir != 0) {
                val += diff * dir;
                --diff;
                dir = -dir;
            } else ++val;
        }
        return ans;
    }
}
