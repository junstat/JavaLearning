package Q0699.Q0605CanPlaceFlowers.solution1;

public class Solution {
    public boolean canPlaceFlowers(int[] A, int n) {
        for (int i = 0, N = A.length, cnt = 0; i < N && n > 0; i++) {
            if (A[i] == 1) cnt = 0;
            else {
                ++cnt;
                if ((cnt == 1 && N == 1) || (cnt == 2 && (i == 1 || i == N - 1)) || cnt == 3) {
                    cnt = 1;
                    --n;
                }
            }
        }
        return n == 0;
    }
}
