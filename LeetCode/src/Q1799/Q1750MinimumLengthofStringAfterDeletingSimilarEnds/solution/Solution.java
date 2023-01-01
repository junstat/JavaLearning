package Q1799.Q1750MinimumLengthofStringAfterDeletingSimilarEnds.solution;

public class Solution {
    public int minimumLength(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = s.length() - 1;

        while (l < r && cs[l] == cs[r]) {
            char c = cs[r];
            while (l >= 0 && l <= r && cs[l] == c) l++;
            while (r >= 0 && l <= r && cs[r] == c) r--;
        }
        return Math.max(0, r - l + 1);
    }
}