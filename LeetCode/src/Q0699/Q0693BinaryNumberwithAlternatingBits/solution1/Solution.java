package Q0699.Q0693BinaryNumberwithAlternatingBits.solution1;

public class Solution {
    public boolean hasAlternatingBits(int n) {
        int cur = -1;
        while (n != 0) {
            int u = n & 1;
            if ((cur ^ u) == 0) return false;
            cur = u;
            n >>= 1;
        }
        return true;
    }
}