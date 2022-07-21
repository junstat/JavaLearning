package Q0199.Q0137SingleNumberII.solution2;

public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {      // 遍历所有二进制位
            int count = 0;
            for (int num : nums) {  // 遍历所有数
                if ((num >>> i & 1) == 1) count++;
            }
            if (count % 3 != 0) ans = ans | 1 << i;
        }
        return ans;
    }
}
