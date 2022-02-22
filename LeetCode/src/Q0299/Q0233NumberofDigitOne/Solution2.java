package Q0299.Q0233NumberofDigitOne;

/*
    对Solution1的简化，省去xyz和d两个变量
 */
public class Solution2 {
    public int countDigitOne(int n) {
        int result = 0;
        for (long k = 1; k <= n; k *= 10) {
            long r = n / k, m = n % k;
            result += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
        }
        return result;
    }
}