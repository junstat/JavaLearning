package Q0099.Q0018FourSum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * General Idea
 * If you have already read and implement the 3sum and 4sum by using the sorting approach:
 * reduce them into 2sum at the end, you might already got the feeling that,
 * all k sum problem can be divided into two problems:
 * <p>
 * 1> 2sum Problem
 * 2> Reduce K sum problem to K – 1 sum Problem
 * Therefore, the ideas is simple and straightforward. We could use recursive to solve this problem.
 * Time complexity is O(N^(K-1)).
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }

    private List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (k == 2) {   // trivial solution(平凡解)
            int low = start, high = len - 1;
            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum == target) {
                    // 此处不能直接使用 Arrays.asList，因为它的返回值是 List
                    // 而List接口中未定义 add(index, E)方法，在后面插入元素的时候会报错
                    res.add(new ArrayList<>(Arrays.asList(nums[low], nums[high])));
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                } else if (sum < target) low++;  // small
                else high--;    // large
            }
        } else {
            for (int i = start; i < len - (k - 1); i++) {
                // avoid duplicates
                if (i > start && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> lastStageResult = kSum(nums, i + 1, k - 1, target - nums[i]);
                for (List<Integer> r : lastStageResult) {
                    r.add(0, nums[i]);
                }
                res.addAll(lastStageResult);
            }
        }
        return res;
    }
}
