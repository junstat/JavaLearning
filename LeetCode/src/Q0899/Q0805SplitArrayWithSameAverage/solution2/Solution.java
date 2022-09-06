package Q0899.Q0805SplitArrayWithSameAverage.solution2;

import java.util.Arrays;

public class Solution {

    int[] nums;
    int[] sums;

    public boolean splitArraySameAverage(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return false;

        Arrays.sort(nums);
        sums = new int[len+1];
        for (int i=0; i<len; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        int sum = sums[len];

        this.nums = nums;

        for (int i=1, stop=len/2; i<=stop; i++) {
            if ( (sum*i) % len == 0
                    && findSum(i, len, (sum*i)/len) )
                return true;
        }

        return false;

    }

    boolean findSum(int k, int pos, int target) {
        //System.out.format("findSum(%d,%d,%d)\n",k,pos,target);
        if (k == 1) {
            while (nums[--pos] > target) {}
            return nums[pos] == target;
        }

        for (int i=pos; sums[i]-sums[i-- -k] >= target; ) {
            if (sums[k-1] <= target-nums[i] && findSum(k-1, i, target-nums[i]))
                return true;
        }

        return false;
    }
}