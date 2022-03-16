package Q0499.Q0413ArithmeticSlices;

/*
    i) We need minimum 3 indices to make arithmetic progression,
    ii) So start at index 2, see if we got two diffs same, so we get a current 1 arith sequence
    iii) At any index i, if we see it forms arith seq with former two, that means running (curr) sequence gets
    extended upto this index, at the same time we get one more sequence (the three numbers ending at i), so curr++.
    Any time this happens, add the curr value to total sum.
    iv) Any time we find ith index does not form arith seq, make currently running no of seqs to zero.
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int cur = 0, sum = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                cur += 1;
                sum += cur;
            } else {
                cur = 0;
            }
        }
        return sum;
    }
}