package Q0199.Q0137SingleNumberII;

/*
    Bit Manipulation
    e.g. nums = [1, 2, 6, 1, 1, 2, 2]
             4 2 1
        1 -> 0 0 1
        2 -> 0 1 0
        6 -> 1 1 0
        1 -> 0 0 1
        1 -> 0 0 1
        2 -> 0 1 0
        2 -> 0 1 0
    count 1: 1 4 3
    1 % 3 != 0, 4 % 3 != 0, 3 % 3 == 0
    意味着，所有的数4位、2位出现了不止3次，1位出现了正好3次。
    进一步地，可以设置 4位为1，2位为1，1位为0，即 1 1 0 -> 6，即为所求
 */
public class Solution2 {
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
