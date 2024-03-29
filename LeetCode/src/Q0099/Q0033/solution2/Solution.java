package Q0099.Q0033.solution2;

public class Solution {
    /*
        Explanation
        Let's say nums looks like this: [12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
        Because it's not fully sorted, we can't do normal binary search. But here comes the trick:
        case 1: If target is let's say 14, then we adjust nums to this, where "inf" means infinity:
        [12, 13, 14, 15, 16, 17, 18, 19, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf]

        case 2: If target is let's say 7, then we adjust nums to this:
        [-inf, -inf, -inf, -inf, -inf, -inf, -inf, -inf, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

        And then we can simply do ordinary binary search.
        Of course we don't actually adjust the whole array but instead adjust only on the fly only the elements we look
         at. And the adjustment is done by comparing both the target and the actual element against nums[0].

        Time: O(log n), Space: O(1)
    */
    public int search(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) return -1;
        // if (nums.length == 1 && nums[0] == target) return 0;

        int rightEndPoint = 10000 + 1;
        int leftEndPoint = -rightEndPoint;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int num = (nums[mid] < nums[0]) == (target < nums[0])
                    ? nums[mid]
                    : target < nums[0] ? leftEndPoint : rightEndPoint;

            if (num == target) return mid;
            else if (num < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}