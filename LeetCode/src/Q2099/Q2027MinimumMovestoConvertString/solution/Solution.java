package Q2099.Q2027MinimumMovestoConvertString.solution;

public class Solution {
    public int minimumMoves(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int l = 0, ans = 0;
        while (l < n) {
            if (cs[l] == 'O') {
                l++;
            } else {
                l += 3;
                ans++;
            }
        }
        return ans;
    }
}
