package Q0299.Q0258AddDigits;

public class Solution1 {

    public int addDigits(int num) {
        while (num >= 10) {
            int curSum = 0;
            while (num != 0) {
                curSum += num % 10;
                num /= 10;
            }
            num = curSum;
        }
        return num;
    }
}
