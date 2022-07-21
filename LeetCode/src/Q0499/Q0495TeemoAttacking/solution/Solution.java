package Q0499.Q0495TeemoAttacking.solution;

public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0, last = -1;
        for (int s : timeSeries) {
            int e = s + duration - 1;
            ans += last < s ? duration : e - last;
            last = e;
        }
        return ans;
    }
}