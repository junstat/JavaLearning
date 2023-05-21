package LCP.Q33;

import java.util.Arrays;

public class Solution {
    public int storeWater(int[] bucket, int[] vat) {
        int n = bucket.length, maxK = Arrays.stream(vat).max().getAsInt();
        if (maxK == 0) return 0;

        int ans = Integer.MAX_VALUE;
        for (int k = 1; k <= maxK; ++k) {
            int cur = k;
            for (int i = 0; i < n; ++i) {
                int least = vat[i] / k + (vat[i] % k != 0 ? 1 : 0);
                cur += Math.max(least - bucket[i], 0);
            }
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}
