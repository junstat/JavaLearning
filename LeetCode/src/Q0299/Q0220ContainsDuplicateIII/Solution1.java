package Q0299.Q0220ContainsDuplicateIII;

import java.util.TreeSet;

/*
    This problem requires to maintain a window of size k of the previous values that can be queried for value ranges.
    The best data structure to do that is Binary Search Tree. As a result maintaining the tree of size k will result
    in time complexity O(N lg K). In order to check if there exists any value of range abs(nums[i] - nums[j]) to
    simple queries can be executed both of time complexity O(lg K)
    Here is the whole solution using TreeMap.
 */
public class Solution1 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) return false;

        TreeSet<Long> values = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long l = (long) nums[i];
            Long floor = values.floor(l);
            Long ceil = values.ceiling(l);
            if ((floor != null && l - floor <= t) ||
                    (ceil != null && ceil - l <= t)) return true;
            values.add(l);
            if (i >= k) values.remove((long) nums[i - k]);
        }
        return false;
    }
}
