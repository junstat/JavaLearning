package Q2799.Q2706;

public class Solution {

    public int buyChoco(int[] nums, int t) {
        int a = 1000, b = 1000;
        for (int num : nums) {
            if (num < a) {
                b = a;
                a = num;
            } else {
                b = Math.min(b, num);
            }
        }
        int leftMoney = t - a - b;
        return leftMoney >= 0 ? leftMoney : t;
    }
}
