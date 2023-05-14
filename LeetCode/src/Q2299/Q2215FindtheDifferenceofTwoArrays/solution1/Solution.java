package Q2299.Q2215FindtheDifferenceofTwoArrays.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> diff1 = getDifference(nums1, nums2);
        List<Integer> diff2 = getDifference(nums2, nums1);
        return Arrays.asList(diff1, diff2);
    }

    List<Integer> getDifference(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        boolean[] seen = new boolean[2001];
        for (int i : nums2) seen[i + 1000] = true;
        for (int i : nums1)
            if (!seen[i + 1000]) {
                seen[i + 1000] = true;
                ans.add(i);
            }
        return ans;
    }
}
