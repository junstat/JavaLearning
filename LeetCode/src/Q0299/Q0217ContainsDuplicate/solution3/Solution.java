package Q0299.Q0217ContainsDuplicate.solution3;

import java.util.HashSet;
import java.util.Set;

// Approach #3 (Set) [Accepted]
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}
