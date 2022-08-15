package Q1499.Q1419MinimumNumberofFrogsCroaking.solution;

public class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        char[] s = croakOfFrogs.toCharArray();
        String t = "croak";
        int[] cnt = new int[5];
        int ans = 0, cur = 0;
        for (char c : s) {
            int n = t.indexOf(c);
            ++cnt[n];
            if (n == 0) ans = Math.max(ans, ++cur);
            else if (--cnt[n - 1] < 0) return -1;
            else if (n == 4) --cur;
        }
        return cur != 0 ? -1 : ans;
    }
}
