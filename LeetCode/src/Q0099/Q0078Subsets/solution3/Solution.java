package Q0099.Q0078Subsets.solution3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length, p = 1 << n;
        List<List<Integer>> subs = new ArrayList<>();
        for (int i = 0; i < p; i++) subs.add(new ArrayList<>());

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) > 0) {
                    subs.get(i).add(nums[j]);
                }
            }
        }
        return subs;
    }
}