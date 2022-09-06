package Q0899.Q0810ChalkboardXORGame.solution;

public class Solution {
    public boolean xorGame(int[] nums) {
        int sum = 0;
        for (int i : nums) sum ^= i;
        return sum == 0 || nums.length % 2 == 0;
    }
}