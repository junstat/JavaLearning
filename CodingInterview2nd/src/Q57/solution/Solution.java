package Q57.solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] nums, int t) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int a = nums[l];
            int b = nums[r];
            if (a + b > t) r--;
            else if (a + b < t) l++;
            else return new ArrayList<>(Arrays.asList(a, b));
        }
        return new ArrayList<>();
    }
}