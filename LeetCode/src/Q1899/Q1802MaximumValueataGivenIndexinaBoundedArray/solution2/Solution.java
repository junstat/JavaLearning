package Q1899.Q1802MaximumValueataGivenIndexinaBoundedArray.solution2;

public class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int lo = 1;
        int hi = maxSum + 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (calcSum(mid, n, index) <= maxSum) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo - 1;
    }

    long calcSum(int x, int n, int index) {
        long sum = n - 1 + x;
        long left = Math.min(index, x - 1);
        sum += (((x - left) + (x - 1))) * left / 2;

        long right = Math.min(n - index - 1, x - 1);
        sum += (((x - 1) + (x - right))) * right / 2;

        sum = sum - left - right;
        return sum;
    }
}
