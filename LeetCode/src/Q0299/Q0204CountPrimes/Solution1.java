package Q0299.Q0204CountPrimes;

// TLE
public class Solution1 {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        int cnt = 0;
        for (int i = 2; i < n; i++)     // 严格小于n
            if (isPrime(i)) cnt++;
        return cnt;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }
}
