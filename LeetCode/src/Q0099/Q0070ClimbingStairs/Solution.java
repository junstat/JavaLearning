package Q0099.Q0070ClimbingStairs;

public class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (n-- > 0)
            a = (b += a) - a;
        return a;
    }
}
