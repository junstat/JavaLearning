package Q2199.Q2180CountIntegersWithEvenDigitSum.solution1;

public class Solution {
    public int countEven(int num) {
        int cnt = num / 10 * 5;
        int sum = 0;
        for (int p = num / 10; p != 0; p /= 10) {
            sum += p % 10;
        }
        if (sum % 2 == 1) {
            cnt += (num % 10 + 1) / 2;
        } else {
            cnt += (num % 10 + 2) / 2;
        }
        return cnt - 1;
    }
}
