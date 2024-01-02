package Q0099.Q0033.solution3;

public class Solution {
    /*
       method 3: 进行二分查找
       将数组中中间分开成左右两部分的时候，一定有一部分数组是有序的。在常规二分查找的时候，查看当前mid为分割位置分隔出来的
       两部分[low, mid] 和 [mid + 1, hi]
       case 1: 若 [low, mid]是有序的部分
            1.a 若 nums[low] <= target <=  nums[mid]  ==> 缩小搜索范围至 [low, mid - 1]
            1.b 不然，在[mid + 1, hi] 中寻找
       case 2: 若[mid + 1, hi]是有序部分
            2.a 若 nums[mid + 1] <= target <= nums[hi] ==> 缩小搜索范围至 [mid + 1, hi]
            2.b 不然在[low, mid - 1] 中寻找
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, hi = nums.length - 1;
        while (low <= hi) {  // 执行二分查找
            int mid = low + (hi - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) hi = mid - 1;    // nums[low] <= target < nums[mid]
                else low = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[hi]) low = mid + 1;   // nums[mid] < target <= nums[high]
                else hi = mid - 1;
            }
        }
        return -1;
    }
}