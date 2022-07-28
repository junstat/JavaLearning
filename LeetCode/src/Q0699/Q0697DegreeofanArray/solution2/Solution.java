package Q0699.Q0697DegreeofanArray.solution2;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>(), last = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            cnt.put(t, cnt.getOrDefault(t, 0) + 1);
            max = Math.max(max, cnt.get(t));
            if (!first.containsKey(t)) first.put(t, i);
            last.put(t, i);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            if (cnt.get(t) == max) {
                ans = Math.min(ans, last.get(t) - first.get(t) + 1);
            }
        }
        return ans;
    }
}