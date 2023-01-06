package Q2199.Q2180CountIntegersWithEvenDigitSum.solution2;

public class Solution {
    public int countEven(int num) {
        int cnt = num / 10 * 5;
        int sum = 0;
        for (int p = num / 10; p != 0; p /= 10) {
            sum += p % 10;
        }
        cnt += (num % 10 + 1 + (sum & 1 ^ 1)) / 2;
        return cnt - 1;
    }
}
