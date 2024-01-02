package Q0099.Q0018.solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int t) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) { // 确定第一个数
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 对第一个数进行去重（相同的数只取第一个）
            for (int j = i + 1; j < n; j++) { // 确定第二个数
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // 对第二个数进行去重（相同的数只取第一个）
                // 确定第三个数和第四个数
                int k = j + 1, p = n - 1;
                while (k < p) {

                    // 对第三个数进行去重（相同的数只取第一个）
                    while (k > j + 1 && k < n && nums[k] == nums[k - 1]) k++;
                    // 如果 k 跳过相同元素之后的位置超过了 p，本次循环结束
                    if (k >= p) break;

                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[p]; // 处理溢出
                    if (sum == t) ans.add(Arrays.asList(nums[i], nums[j], nums[k++], nums[p]));
                    else if (sum > t) p--;
                    else k++;
                }
            }
        }
        return ans;
    }
}
