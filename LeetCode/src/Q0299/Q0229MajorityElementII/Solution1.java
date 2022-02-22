package Q0299.Q0229MajorityElementII;

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
public class Solution1 {

    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int candidate1 = nums[0], candidate2 = nums[0], count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }
        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);
        return result;
    }
}
