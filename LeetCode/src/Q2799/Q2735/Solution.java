package Q2799.Q2735;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Solution {
    @Test
    public void test1() {
        int[] nums = {20, 1, 15};
        int x = 5;
        assertThat(minCost(nums, x), equalTo(13L));
    }

    public long minCost(int[] nums, int x) {
        int n = nums.length;
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            ans[i] += (long) i * x;
            int cur = nums[i];
            for (int k = 0; k < n; k++) {
                cur = Math.min(cur, nums[(i - k + n) % n]);
                ans[k] += cur;
            }
        }
        return Arrays.stream(ans).min().getAsLong();
    }
}
