package Q0699.Q0693BinaryNumberwithAlternatingBits.solution2;

public class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }
}