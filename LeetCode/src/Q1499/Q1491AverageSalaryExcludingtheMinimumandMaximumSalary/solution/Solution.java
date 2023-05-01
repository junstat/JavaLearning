package Q1499.Q1491AverageSalaryExcludingtheMinimumandMaximumSalary.solution;

public class Solution {
    public double average(int[] salary) {
        int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE, s = 0;
        for (int n : salary) {
            mx = Math.max(mx, n);
            mn = Math.min(mn, n);
            s += n;
        }
        return (s - mx - mn) * 1.0 / (salary.length - 2);
    }
}
