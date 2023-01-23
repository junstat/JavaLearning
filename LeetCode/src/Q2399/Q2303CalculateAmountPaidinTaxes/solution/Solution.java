package Q2399.Q2303CalculateAmountPaidinTaxes.solution;

public class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int ans = 0, pre = 0;
        for (int[] bracket : brackets) {
            int up = bracket[0], p = bracket[1];
            if (income <= up) {
                ans += (income - pre) * p;
                break;
            }
            ans += (up - pre) * p;
            pre = up;
        }
        return ans * 1.0 / 100;
    }
}
