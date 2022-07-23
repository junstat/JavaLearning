package Q0299.Q0201BitwiseANDofNumbersRange.solution4;

/*
    分析: 结合补码的知识，`按位取反，再加1`，其实相当于取了一个相反数
    ~Integer.highestOneBit(m ^ n) + 1 <=> -Integer.highestOneBit(m ^ n)
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) return m;
        return m & -Integer.highestOneBit(m ^ n);
    }
}
