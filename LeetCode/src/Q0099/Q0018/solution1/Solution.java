package Q0099.Q0018.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }

    private List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (k == 2) {   // trivial solution(平凡解)
            int lo = start, hi = len - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum == target) {
                    // 此处不能直接使用 Arrays.asList，因为它的返回值是 List
                    // 而List接口中未定义 add(index, E)方法，在后面插入元素的时候会报错
                    res.add(new ArrayList<>(Arrays.asList(nums[lo], nums[hi])));
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++;
                    hi--;
                } else if (sum < target) lo++;  // small
                else hi--;    // large
            }
        } else {
            for (int i = start; i < len - (k - 1); i++) {
                // avoid duplicates
                if (i > start && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> lastStageResult = kSum(nums, i + 1, k - 1, target - nums[i]);
                for (List<Integer> r : lastStageResult) r.add(0, nums[i]);
                res.addAll(lastStageResult);
            }
        }
        return res;
    }
}
