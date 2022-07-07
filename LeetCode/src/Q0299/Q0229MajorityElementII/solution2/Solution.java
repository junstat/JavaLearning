package Q0299.Q0229MajorityElementII.solution2;

import java.util.ArrayList;
import java.util.List;

/*
    The essential concepts is you keep a counter for the majority number X. If you find a number Y that is not X, the
    current counter should deduce 1. The reason is that if there is 5 X and 4 Y, there would be one (5-4) more X than
     Y. This could be explained as "4 X being paired out by 4 Y".

    And since the requirement is finding the majority for more than ceiling of [n/3], the answer would be less than
    or equal to two numbers.
    So we can modify the algorithm to maintain two counters for two majorities.
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int a = 0, b = 0;
        int c1 = 0, c2 = 0;
        for (int i : nums) {
            if (c1 != 0 && a == i) c1++;
            else if (c2 != 0 && b == i) c2++;
            else if (c1 == 0 && ++c1 >= 0) a = i;
            else if (c2 == 0 && ++c2 >= 0) b = i;
            else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i : nums) {
            if (a == i) c1++;
            else if (b == i) c2++;
        }
        List<Integer> ans = new ArrayList<>();
        if (c1 > n / 3) ans.add(a);
        if (c2 > n / 3) ans.add(b);
        return ans;
    }
}