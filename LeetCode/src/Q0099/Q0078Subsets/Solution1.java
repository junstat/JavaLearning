package Q0099.Q0078Subsets;

import java.util.ArrayList;
import java.util.List;

/*
    Iterative
    Using [1, 2, 3] as an example, the iterative process is like:
    1) initially, one empty subset [[]]
    2) Adding 1 to []: [[], [1]]
    3) Adding 2 to [] and [1]: [[], [1], [2], [1, 2]]
    4) Adding 3 to [], [1], [2] and [1, 2]: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
 */
public class Solution1 {
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