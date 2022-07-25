package Q0699.Q0633SumofSquareNumbers.solution3;

public class Solution {
    public boolean judgeSquareSum(int c) {
        for (int i = 2, cnt = 0; i * i <= c; i++, cnt = 0) {
            while (c % i == 0 && ++cnt > 0) c /= i;
            if (i % 4 == 3 && cnt % 2 != 0) return false;
        }
        return c % 4 != 3;
    }
}