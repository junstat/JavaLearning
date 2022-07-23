package Q0299.Q0201BitwiseANDofNumbersRange.solution2;

public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        return (right > left) ? (rangeBitwiseAnd(left >> 1, right >> 1) << 1) : left;
    }
}
