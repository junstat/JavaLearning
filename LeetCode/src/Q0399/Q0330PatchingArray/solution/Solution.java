package Q0399.Q0330PatchingArray.solution;

/*
    Let miss be the smallest sum in [0, n] that we might be missing. Meaning we already know we can build all sums in
    [0, miss). Then if we have a number num <= miss in the given array, we can add it to those smaller sums o build all
    sums in [0, miss+num). If we don't, then we must add such a number to the array, and it's best to add miss itself,
    to maximize the reach.
    https://leetcode.com/problems/patching-array/discuss/78488/Solution-%2B-explanation
 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int added = 0, i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                added++;
            }
        }
        return added;
    }
}