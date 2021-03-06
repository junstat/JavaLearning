package Q0399.Q0321CreateMaximumNumber.solution;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    算法思想同:
    https://leetcode-cn.com/problems/create-maximum-number/solution/pin-jie-zui-da-shu-by-leetcode-solution/
 */
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
    }

    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }

    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }

    // 单调栈
    public int[] maxArray2(int[] nums, int len) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (stack.size() + nums.length - i > len && !stack.isEmpty() && stack.peek() < nums[i])
                stack.pop();
            if (stack.size() < len) stack.push(nums[i]);
        }
        int[] result = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
