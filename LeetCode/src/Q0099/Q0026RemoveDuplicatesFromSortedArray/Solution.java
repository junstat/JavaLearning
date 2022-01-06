package Q0099.Q0026RemoveDuplicatesFromSortedArray;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int uniqElemIndex = 0;
        for (int n : nums)
            if (uniqElemIndex == 0 || n > nums[uniqElemIndex - 1])
                nums[uniqElemIndex++] = n;
        return uniqElemIndex;
    }
}
