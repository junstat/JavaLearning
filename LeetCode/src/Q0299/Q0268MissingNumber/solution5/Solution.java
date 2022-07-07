package Q0299.Q0268MissingNumber.solution5;

/*
    分析:
    使用异或运算，运算法则
    1) 归零律: a xor a = 0
    2) 恒等律: a xor 0 = a
    3) 交换律: a xor b = b xor a
    4) 自反率: a xor b xor a = b

    利用1)、2)、4)
    因为下标 in [0, n)，nums in [0, n]，当然中间会missing一个。
    可以导出, a. 下标 并 [n] 是完整是 [0, n]
             b. 除missing num外 nums也是 [0, n]
             结合a., b.可得0,n中所有数均出现了2次，除missing num外
             利用1)、2)可以把所有出现2次的数抵消掉，利用4)可以找出missing num
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int res = 0, i = 0;
        for (; i < nums.length; i++) res ^= i ^ nums[i];
        return res ^ i;
    }
}
