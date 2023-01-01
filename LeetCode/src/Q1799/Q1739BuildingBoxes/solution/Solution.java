package Q1799.Q1739BuildingBoxes.solution;

public class Solution {
    public int minimumBoxes(int n) {
        int ans = 0, maxN = 0;
        for (int i = 1; maxN + ans + i <= n; ++i) {
            ans += i;
            maxN += ans;
        }
        for (int j = 1; maxN < n; ++j) {
            ++ans;
            maxN += j;
        }
        return ans;
    }
}