package Q0799.Q0754ReachaNumber.solution;

public class Solution {
    public int reachNumber(int target) {
        int i = 0, sum = 0;
        target = Math.abs(target);
        while (sum < target || (sum - target) % 2 != 0) sum += ++i;
        return i;
    }
}
