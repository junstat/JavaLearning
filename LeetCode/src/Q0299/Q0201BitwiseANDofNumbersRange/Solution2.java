package Q0299.Q0201BitwiseANDofNumbersRange;

// recursive
public class Solution2 {
    public int rangeBitwiseAnd(int left, int right) {
        return (right > left) ? (rangeBitwiseAnd(left >> 1, right >> 1) << 1) : left;
    }
}
