package Q0399.Q0324WiggleSortII;


import org.junit.Test;

import java.util.Arrays;

public class Solution {
    @Test
    public void test1() {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test3() {
        int[] nums = {1, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 3};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n == 1 || n == 0) return;

        int mid = findKthSmall(nums, n / 2);    // median
        int largePos = 1; // Odd position from start for larger then median numbers
        int smallPos = n % 2 == 0 ? n - 2 : n - 1;  // Even position from end from smaller then median numbers
        int cur = 0;
        while (cur <= smallPos) {
            // Avoiding already checked even positions from the end
            if (nums[cur] < mid && (cur % 2 != 0)) {
                exchange(nums, cur, smallPos);
                smallPos -= 2;
            }
            // Avoiding already checked odd position from the start
            else if (nums[cur] > mid && (cur % 2 == 0)) {
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
        if (k == pos)
            return nums[pos];
        else if (k < pos)
            return findKthSmallAux(nums, start, pos - 1, k);
        else
            return findKthSmallAux(nums, pos + 1, end, k);
    }

    private int partition(int[] nums, int p, int r) {
        int x = nums[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (nums[j] <= x) {
                // i++;
                exchange(nums, ++i, j);
            }
        }
        // exchange(nums, i + 1, r);
        // return i + 1;
        exchange(nums, ++i, r);
        return i;
    }

    private void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
