package Q0399.Q0303RangeSumQueryImmutable;

public class Solution {
}

/*
    The idea is fairly straightforward: create an array accu that stores the accumulated sum for nums such that
    accu[i] = nums[0] + ... + nums[i - 1] in the initializer of NumArray. Then just return accu[j + 1] - accu[i] in
    sumRange. You may try the example in the problem statement to convince yourself of this idea.
 */
class NumArray {

    private int[] accu;

    public NumArray(int[] nums) {
        accu = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            accu[i + 1] = accu[i] + nums[i];
    }

    public int sumRange(int left, int right) {
        return accu[right + 1] - accu[left];
    }
}