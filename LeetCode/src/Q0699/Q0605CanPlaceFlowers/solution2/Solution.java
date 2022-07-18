package Q0699.Q0605CanPlaceFlowers.solution2;

public class Solution {
    public boolean canPlaceFlowers(int[] A, int n) {
        for (int i = 0, len = A.length; i < len && n > 0;) {
            if (A[i] == 1) {
                i += 2;
            } else if (i == A.length - 1 || A[i + 1] == 0) {
                n--;
                i += 2;
            } else {
                i += 3;
            }
        }
        return n <= 0;
    }
}