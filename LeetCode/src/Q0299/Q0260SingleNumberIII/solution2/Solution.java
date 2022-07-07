package Q0299.Q0260SingleNumberIII.solution2;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int n : nums) {
            diff ^= n;
        }
        diff = Integer.highestOneBit(diff);
        int[] result = new int[2];
        for (int n : nums) {
            if ((diff & n) == 0) {
                result[0] ^= n;
            } else {
                result[1] ^= n;
            }
        }
        return result;
    }
}
