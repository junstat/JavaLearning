package Q0199.Q0189RotateArray;

/*
   Solution 1: Brute Force
   The simplest approach is to rotate all the elements of the array in k steps by rotating the elements by 1 unit in
   each step.
 */
public class Solution {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}