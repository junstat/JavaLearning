package Q0399.Q0347TopKFrequentElements.solution1;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        // int[]的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), cnt = entry.getValue();
            if (q.size() == k) {
                if (q.peek()[1] < cnt) {
                    q.poll();
                    q.add(new int[]{num, cnt});
                }
            } else {
                q.add(new int[]{num, cnt});
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = q.poll()[0];
        return ans;
    }
}
