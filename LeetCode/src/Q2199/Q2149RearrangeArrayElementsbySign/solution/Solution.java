package Q2199.Q2149RearrangeArrayElementsbySign.solution;

public class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length, pos = 0, neg = 1;
        var ans = new int[n];
        for (int num : nums) {
            if (num > 0) {
                ans[pos] = num;
                pos += 2;
            }
            if (num < 0) {
                ans[neg] = num;
                neg += 2;
            }
        }
        return ans;
    }
}
