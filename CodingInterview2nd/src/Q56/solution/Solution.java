package Q56.solution;

public class Solution {
    public int[] FindNumsAppearOnce(int[] nums) {
        int diff = 0;
        for (int n : nums) diff ^= n;
        diff = Integer.highestOneBit(diff);
        int[] ans = new int[2];
        for (int n : nums) {
            if ((diff & n) == 0) ans[0] ^= n;
            else ans[1] ^= n;
        }
        return ans;
    }
}