package Q0299.Q0201BitwiseANDofNumbersRange.solution5;

/*
    分析，追highestOneBit的源码为:
    public static int highestOneBit(int i) {
        // HD, Figure 3-1
        i |= (i >>  1);  // 把最高位的1复制给旁边，如，0001 xxxx -> 0001 1xxx，此时有2个1了
        i |= (i >>  2);  // 0001 1xxx -> 0001 111x
        i |= (i >>  4);  // ...
        i |= (i >>  8);  // ...
        i |= (i >> 16);  // 最终， 0001 xxxx -> 0001 1111
        return i - (i >>> 1); // 0001 1111 - 0000 1111 = 0001 0000
    }

    取 m = 18, n = 30
    m = 18 -> 10010
    n = 30 -> 11110
    沿高位往低位比较，发现在8位出现了差异，由前面的分析可以导出，我们的结果为 10000 -> 16
    可以取 m -> 10010 与 10000 相与可以得到结果，即 10010 & 10000 = 10000->16
    借用highestOneBit源码的手段，改进对于任意情况如何构造 10000?
    1) m^n = 01100
    2) 01100 -> 01111
    3) ~01111 -> 10000
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) return m;
        int i = m ^ n;
        i |= (i >> 1);
        i |= (i >> 2);
        i |= (i >> 4);
        i |= (i >> 8);
        i |= (i >> 16);
        return m & ~i;
    }
}
