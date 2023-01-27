package Q1699.Q1663SmallestStringWithAGivenNumericValue.solution;

public class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder ans = new StringBuilder();
        for (int rest = n; rest >= 1; rest--) {
            int bound = k - 26 * (rest - 1);
            if (bound > 0) {
                ans.append((char) ('a' + bound - 1));
                k -= bound;
            } else {
                ans.append('a');
                k -= 1;
            }
        }
        return ans.toString();
    }
}
