package Q0099.Q0078.solution2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subs = new ArrayList<>();
        subs.add(new ArrayList<>());
        for (int num : nums) {
            int n = subs.size();
            for (int i = 0; i < n; i++) {
                subs.add(new ArrayList<>(subs.get(i)));
                subs.get(subs.size() - 1).add(num);
            }
        }
        return subs;
    }
}