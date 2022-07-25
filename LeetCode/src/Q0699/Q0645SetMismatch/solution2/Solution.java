package Q0699.Q0645SetMismatch.solution2;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] cnts = new int[n + 1];
        int tot = (1 + n) * n / 2;
        int sum = 0, set = 0;
        for (int x : nums) {
            sum += x;
            if (cnts[x] == 0) set += x;
            cnts[x] = 1;
        }
        return new int[]{sum - set, tot - set};
    }
}