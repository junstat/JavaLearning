package Q21.solution2;

public class Solution {
    public int[] reOrderArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int odd = 0, even = 0;
        for (int num : nums) if ((num & 1) == 1) even++;
        for (int num : nums) {
            if ((num & 1) == 1) ans[odd++] = num;
            else ans[even++] = num;
        }
        return ans;
    }
}
