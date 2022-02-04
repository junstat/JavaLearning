package Q0299.Q0213HouseRobberII;

/*
    This problem is a little tricky at first glance. However, if you have finished the House Robber problem, this
    problem can simply be decomposed into two House Robber problems.
    Suppose there are n houses, since house 0 and n - 1 are now neighbors, we cannot rob them together and thus the
    solution is now the maximum of

    1) Rob houses 0 to n - 2;
    2) Rob houses 1 to n - 1.
    The code is as follows. Some edge cases (n < 2) are handled explicitly.
 */
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) return n != 0 ? nums[0] : 0;
        return Math.max(robber(nums, 0, n - 2), robber(nums, 1, n - 1));
    }

    private int robber(int[] nums, int l, int r) {
        int pre = 0, cur = 0;
        for (int i = l; i <= r; i++) {
            int tmp = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = tmp;
        }
        return cur;
    }
}
