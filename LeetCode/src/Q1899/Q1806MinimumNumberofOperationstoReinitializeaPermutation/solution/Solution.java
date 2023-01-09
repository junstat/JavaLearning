package Q1899.Q1806MinimumNumberofOperationstoReinitializeaPermutation.solution;

public class Solution {
    public int reinitializePermutation(int n) {
        if (n == 2) {
            return 1;
        }
        int k = 1;
        int pow2 = 2;
        while (pow2 != 1) {
            k++;
            pow2 = pow2 * 2 % (n - 1);
        }
        return k;
    }
}