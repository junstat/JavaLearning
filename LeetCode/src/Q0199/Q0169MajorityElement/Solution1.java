package Q0199.Q0169MajorityElement;

import java.util.HashMap;
import java.util.Map;

/*
    Hash Table
    Count the number of appearances for each distinct number in nums, once we see a number appear more than n / 2
    times, it is the majority element.
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (counter.containsKey(num))
                counter.put(num, counter.get(num) + 1);
            else
                counter.put(num, 1);

            if (counter.get(num) > nums.length / 2)
                return num;
        }
        return 0;
    }
}
