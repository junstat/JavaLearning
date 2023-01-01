package Q2099.Q2032TwoOutofThree.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] cnt = new int[101];
        for (int i : nums1) {
            cnt[i] |= 1;
        }
        for (int i : nums2) {
            cnt[i] |= 2;
        }
        for (int i : nums3) {
            cnt[i] |= 4;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            if (cnt[i] > 2 && cnt[i] != 4) {
                ans.add(i);
            }
        }
        return ans;
    }
}
