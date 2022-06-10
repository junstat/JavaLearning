package Q0499.Q0441ArrangingCoins;

public class Solution1 {
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
    }
}