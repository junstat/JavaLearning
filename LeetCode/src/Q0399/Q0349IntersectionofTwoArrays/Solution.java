package Q0399.Q0349IntersectionofTwoArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    Binary search
    Time complexity: O(nlogn)
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (int num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) result[i++] = num;
        return result;
    }

    private boolean binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    }
}
