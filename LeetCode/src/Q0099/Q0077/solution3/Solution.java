package Q0099.Q0077.solution3;

import java.util.ArrayList;
import java.util.List;

/*
    Iteration
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        int[] nums = new int[k];
        while (i >= 0) {
            nums[i]++;      // 当前数字加1
            if (nums[i] > n) --i; // 当前数字大于n，对应回溯法的 start = n + 1，返回上一层
            else if (i == k - 1) {  // 数字个数够了
                List<Integer> curResult = new ArrayList<>();
                for (int num : nums) curResult.add(num);
                result.add(curResult);
            } else {    // 进入更新下一个数字
                ++i;
                nums[i] = nums[i - 1]; // 把下一个数字置为上一个数字
            }
        }
        return result;
    }
}
