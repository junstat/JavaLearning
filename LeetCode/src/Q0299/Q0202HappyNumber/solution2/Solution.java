package Q0299.Q0202HappyNumber.solution2;

public class Solution {
    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(digitSquareSum(fast));
            if (fast == 1) return true;
        } while (slow != fast);
        return false;
    }

    private int digitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int t = n % 10;
            sum += t * t;
            n /= 10;
        }
        return sum;
    }
}
