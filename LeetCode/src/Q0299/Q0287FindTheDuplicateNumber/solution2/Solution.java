package Q0299.Q0287FindTheDuplicateNumber.solution2;

public class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] dups = new boolean[nums.length + 1];

        for (int num : nums) {
            if (dups[num]) return num;
            else dups[num] = true;
        }
        return 1;
    }
}
