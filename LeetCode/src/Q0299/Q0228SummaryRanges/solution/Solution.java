package Q0299.Q0228SummaryRanges.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 1) {
            list.add(nums[0] + "");
            return list;
        }
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1) i++;
            if (start != nums[i]) list.add(start + "->" + nums[i]);
            else list.add(start + "");
        }
        return list;
    }
}
