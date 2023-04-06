package Q1099.Q1017ConverttoBaseNeg2.solution2;

public class Solution {
    public String base2(int N) {
        if (N == 0 || N == 1) return Integer.toString(N);
        return base2(N >> 1) + Integer.toString(N & 1);
    }

    public String baseNeg2(int N) {
        if (N == 0 || N == 1) return Integer.toString(N);
        return baseNeg2(-(N >> 1)) + Integer.toString(N & 1);
    }
}
