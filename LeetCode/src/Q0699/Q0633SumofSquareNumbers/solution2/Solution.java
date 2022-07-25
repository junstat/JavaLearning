package Q0699.Q0633SumofSquareNumbers.solution2;

public class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            int cur = a * a + b * b;
            if (cur == c) {
                return true;
            } else if (cur > c) {
                b--;
            } else {
                a++;
            }
        }
        return false;
    }
}