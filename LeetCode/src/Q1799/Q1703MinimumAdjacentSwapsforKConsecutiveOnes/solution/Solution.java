package Q1799.Q1703MinimumAdjacentSwapsforKConsecutiveOnes.solution;

public class Solution {
    public int minMoves(int[] nums, int k) {
        int n = nums.length;
        int[] pos = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                pos[idx++] = i;
            }
        }

        int ans = 0, cnt = 0, mid = k / 2;
        // 准备第一个活动窗口
        for (int i = 1; i < k; i++) {
            cnt += (pos[i] - pos[i - 1] - 1) * Math.min(i, k - i);
        }
        ans = cnt;
        // 移动滑动窗口
        for (int i = k; i < idx; i++) {
            cnt -= pos[i - k + mid] - pos[i - k]; // 左边1离中位点的距离
            cnt += pos[i] - pos[i - mid]; // 右边新增的1离中位点的距离
            ans = Math.min(ans, cnt);
        }

        return ans;
    }
}