package Q0499.Q0441ArrangingCoins.solution1;

public class Solution {
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
    }
}