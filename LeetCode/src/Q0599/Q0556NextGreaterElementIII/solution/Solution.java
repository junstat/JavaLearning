package Q0599.Q0556NextGreaterElementIII.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int nextGreaterElement(int x) {
        List<Integer> nums = new ArrayList<>();
        while (x != 0) {
            nums.add(x % 10);
            x /= 10;
        }
        int n = nums.size(), idx = -1;
        for (int i = 0; i < n - 1 && idx == -1; i++) {
            if (nums.get(i + 1) < nums.get(i)) idx = i + 1;
        }
        if (idx == -1) return -1;
        for (int i = 0; i < idx; i++) {
            if (nums.get(i) > nums.get(idx)) {
                swap(nums, i, idx);
                break;
            }
        }
        for (int l = 0, r = idx - 1; l < r; l++, r--) swap(nums, l, r);
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) ans = ans * 10 + nums.get(i);
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    void swap(List<Integer> nums, int a, int b) {
        int c = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, c);
    }
}