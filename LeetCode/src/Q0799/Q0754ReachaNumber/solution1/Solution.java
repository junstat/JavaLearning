package Q0799.Q0754ReachaNumber.solution1;

public class Solution {
    public int reachNumber(int target) {
        if (target < 0) target = -target;
        int k = (int) Math.sqrt(2 * target), dist = k * (k + 1) / 2;
        while (dist < target || (dist - target) % 2 == 1) {
            k++;
            dist = k * (k + 1) / 2;
        }
        return k;
    }
}