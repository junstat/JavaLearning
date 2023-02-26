package Q0899.Q0870AdvantageShuffle.solution1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        TreeSet<Integer> tset = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) == 1) tset.add(x);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            Integer cur = tset.ceiling(nums2[i] + 1);
            if (cur == null) cur = tset.ceiling(-1);
            ans[i] = cur;
            map.put(cur, map.get(cur) - 1);
            if (map.get(cur) == 0) tset.remove(cur);
        }
        return ans;
    }
}