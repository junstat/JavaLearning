package Q0799.Q0793PreimageSizeofFactorialZeroesFunction.solution;

public class Solution {
    public int preimageSizeFZF(int k) {
        for (int f = 305175781; f >= 1; f = (f - 1) / 5) {
            if (k == 5 * f) return 0;
            k %= f;
        }
        return 5;
    }
}