package Q0299.Q0204CountPrimes;

public class Solution2 {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        boolean[] isPrime = new boolean[n];
        // 偶数必定不是素数，只有剩下一半奇数可能是素数
        int cnt = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (isPrime[i]) continue;   // 说明i已经是素数，且已经剔除过了

            // 从奇数中剔除不是素数的数
            //我们要剔除的是 i 的 奇数倍
            // 1) 为什么是 i * i开始呢   我们打个比方，假设我们此时i = 5
            //那么我们开始剔除  j = 1 时就是本身，此时要么已经被剔除，要么就是素数，所以 1 不考虑
            //当 j = 2 || j = 4时，乘积为偶数所以也不在我们考虑范围内
            //当 j = 3时，我们考虑 3 * 5 但是这种情况已经是当 i = 3的时候被考虑进去了所以我们只要考虑之后的就可以了

            // 2) 那么为什么 j = j + i * 2呢
            //根据上面所说 我们从3开始考虑 3 * 3,3 * 5,3 * 7....只要 j < n 我们就剔除
            //带入i : i * i, i * ( i + 2 ) , i * ( i + 4 )....
            for (int j = i * i; j < n; j += 2 * i) {
                if (!isPrime[j]) {
                    --cnt;
                    isPrime[j] = true;
                }
            }
        }
        return cnt;
    }
}
