package Q0799.Q0786KthSmallestPrimeFraction.solution3;

public class Solution {
    double eps = 1e-8;
    int[] arr;
    int n, a, b;

    public int[] kthSmallestPrimeFraction(int[] _arr, int k) {
        arr = _arr;
        n = arr.length;
        double l = 0, r = 1;
        while (r - l > eps) {
            double mid = (l + r) / 2;
            if (check(mid) >= k) r = mid;
            else l = mid;
        }
        return new int[]{a, b};
    }

    int check(double x) {
        int ans = 0;
        for (int i = 0, j = 1; j < n; j++) {
            while (arr[i + 1] * 1.0 / arr[j] <= x) i++;
            if (arr[i] * 1.0 / arr[j] <= x) ans += i + 1;
            if (Math.abs(arr[i] * 1.0 / arr[j] - x) < eps) {
                a = arr[i];
                b = arr[j];
            }
        }
        return ans;
    }
}