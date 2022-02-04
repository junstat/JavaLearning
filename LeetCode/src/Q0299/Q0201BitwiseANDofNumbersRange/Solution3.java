package Q0299.Q0201BitwiseANDofNumbersRange;

/*
    分析
    取 m = 18, n = 30
    m = 18 -> 10010
    n = 30 -> 11110
    沿高位往低位比较，发现在8位出现了差异，由前面的分析可以导出，我们的结果为 10000 -> 16

    可以取 m -> 10010 与 10000 相与可以得到结果，即 10010 & 10000 = 10000->16

    对于任意情况如何构造 10000?
    1) m^n = 01100
    2) Integer.highestOneBit(m ^ n) -> 01000
     // highestOneBit:Returns an int value with at most a single one-bit, in the position of the highest-order
     // ("leftmost") one-bit in the specified int value.
    3) ~Integer.highestOneBit(m ^ n) -> 10111
    4) ~Integer.highestOneBit(m ^ n) + 1 -> 10000
 */
public class Solution3 {

    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) return m;
        return m & ~Integer.highestOneBit(m ^ n) + 1;
    }
}
