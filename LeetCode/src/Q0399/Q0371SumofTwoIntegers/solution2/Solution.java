package Q0399.Q0371SumofTwoIntegers.solution2;

/*
    考虑两个二进制位相加的四种情况如下：

0 + 0 = 0
0 + 1 = 1
1 + 0 = 1
1 + 1 = 0 (进位)

可以发现，对于整数 a 和 b：
    在不考虑进位的情况下，其无进位加法结果为 a⊕b
    而所有需要进位的位为 a & b，进位后的进位结果为 (a & b) << 1
 */
public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
