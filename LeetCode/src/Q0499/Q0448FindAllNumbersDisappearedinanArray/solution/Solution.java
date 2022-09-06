package Q0499.Q0448FindAllNumbersDisappearedinanArray.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) swap(nums, i, nums[i] - 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) ans.add(i + 1);
        }
        return ans;
    }

    void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}