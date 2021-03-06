package Q0099.Q0031NextPermutation.solution;

/*
  According to Wikipedia, a man named Narayana Pandita presented the following simple algorithm
  to solve this problem in the 14th century.

   1> Find the largest index k such that nums[k] < nums[k + 1]. If no such index exists, just reverse nums and done.
   2> Find the largest index l > k such that nums[k] < nums[l].
   3> Swap nums[k] and nums[l].
   4> Reverse the sub-array nums[k + 1:].

   The above algorithm can also handle duplicates and thus can be further
   used to solve Permutations and Permutations II.
   Time: O(n), Space: O(1)

   算法推导:
   1) 希望下一个数比当前数大。需要把后面的"大数"与前面的"小数"交换，就能得到一个更大的数。
      如: 123456，将 5和6 交换就能得到一个更大的数。
   2) 希望下一个数增加的幅度尽可能的小。
       2.1) 在尽可能靠右低位进行交换，需要从后往前查找。
       2.2) 将一个尽可能小的大数与前面的小数交换。
       2.3) 将大数换到前面后，需要将大数后面的所有数重置为升序，升序排列就是最小的排列。

 */
public class Solution {
    public void nextPermutation(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) return;
        int n = nums.length, k = n - 2, l = n - 1;
        while (k >= 0 && nums[k] >= nums[k + 1]) k--;  // Find 1st id k that breaks descending order
        if (k >= 0) {                                  // If not entirely descending
            while (nums[l] <= nums[k]) l--;            // Find rightmost first larger id l
            swap(nums, k, l);                          // swap k and l
        }
        reverse(nums, k + 1, n - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) swap(nums, i, j);
    }
}
