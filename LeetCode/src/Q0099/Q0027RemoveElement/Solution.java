package Q0099.Q0027RemoveElement;

public class Solution {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        for (int n : nums) {
            if (n != val) nums[i++] = n;
        }
        return i;
    }
}
