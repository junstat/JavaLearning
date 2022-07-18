package Q0399.Q0376WiggleSubsequence.solution3;

public class Solution {
    public int wiggleMaxLength(int[] A) {
        int dir = 0, len = 1;
        for (int i = 1; i < A.length; i++) {
            int d = A[i] - A[i - 1];
            d = Integer.compare(d, 0);
            if (d != 0 && d != dir) {
                ++len;
                dir = d;
            }
        }
        return len;
    }
}