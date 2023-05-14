package Q1899.Q1822SignoftheProductofanArray.solution;

public class Solution {
    public int arraySign(int[] nums) {
        int ans = 1;
        for (int x : nums) {
            if (x == 0) return 0;
            if (x < 0) ans *= -1;
        }
        return ans;
    }
}