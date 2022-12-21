package Q1799.Q1753MaximumScoreFromRemovingStones.solution;

public class Solution {
    public int maximumScore(int a, int b, int c) {
        int sum = a + b + c;
        int max = Math.max(Math.max(a, b), c);
        return Math.min(sum - max, sum / 2);
    }
}