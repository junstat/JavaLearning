package Q0499.Q0414ThirdMaximumNumber.solution2;

public class Solution {
    long INF = (long) -1e18;

    public int thirdMax(int[] nums) {
        long a = INF, b = INF, c = INF;
        for (int x : nums) {
            if (x > a) {
                c = b;
                b = a;
                a = x;
            } else if (x < a && x > b) {
                c = b;
                b = x;
            } else if (x < b && x > c) {
                c = x;
            }
        }
        return c != INF ? (int) c : (int) a;
    }
}