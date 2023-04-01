package Q0899.Q0849MaximizeDistancetoClosestPerson.solution;

public class Solution {
    public int maxDistToClosest(int[] seats) {
        int ans = 0, n = seats.length, last = -1;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                ans = last < 0 ? i : Math.max(ans, (i - last) / 2);
                last = i;
            }
        }
        ans = Math.max(ans, n - last - 1);
        return ans;
    }
}