package Q0399.Q0324WiggleSortII;

/*
    https://leetcode.com/problems/wiggle-sort-ii/discuss/755415/O(n)-%2B-O(1)-after-median-NO-indexing-required
 */
public class Solution1 {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        if (len == 1 || len == 0) return;

        int mid = findKthSmall(nums, (len - 1) / 2); //median
        int largePos = 1; //Odd position from start for larger than median numbers
        int smallPos = len % 2 == 0 ? len - 2 : len - 1; //Even position from end for smaller than median numbers
        int cur = 0;
        while (cur < len) {
            //Avoiding already checked even positions from the end
            if (nums[cur] < mid && (cur < smallPos || (cur >= smallPos && cur % 2 != 0))) {
                exchange(nums, cur, smallPos);
                smallPos -= 2;
            }
            //Avoiding already checked odd positions from the start
            else if (nums[cur] > mid && (largePos < cur || (largePos >= cur && cur % 2 == 0))) {
                exchange(nums, cur, largePos);
                largePos += 2;
            } else cur++;
        }
    }

    private int findKthSmall(int[] nums, int k) {
        return findKthSmallAux(nums, 0, nums.length - 1, k);
    }

    private int findKthSmallAux(int[] nums, int start, int end, int k) {
        int pos = partition(nums, start, end);
        if (pos == k) return nums[pos];
        if (pos < k)
            return findKthSmallAux(nums, pos + 1, end, k);
        else
            return findKthSmallAux(nums, start, pos - 1, k);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (nums[j] <= pivot)
                exchange(nums, ++i, j);
        }
        exchange(nums, ++i, end);
        return i;
    }

    private void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}