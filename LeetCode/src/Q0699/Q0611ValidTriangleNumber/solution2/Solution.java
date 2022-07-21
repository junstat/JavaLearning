package Q0699.Q0611ValidTriangleNumber.solution2;

import java.util.Arrays;

public class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int l = 0, r = j - 1;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (nums[mid] + nums[j] > nums[i]) r = mid;
                    else l = mid + 1;
                }
                if (l == r && nums[r] + nums[j] > nums[i]) ans += j - r;
            }
        }
        return ans;
    }
}