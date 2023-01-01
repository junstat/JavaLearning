package Q1799.Q1759CountNumberofHomogenousSubstrings.solution;

public class Solution {
    public int countHomogenous(String _s) {
        int res = 0;
        int left = 0, right = 0;
        char[] s = _s.toCharArray();

        while (right < s.length) {
            if (s[right] != s[left]) {
                left = right;
            } else {
                res = (res + right - left + 1) % 1000000007;    //当前窗口宽度正好就是增加的子串数目
                right++;
            }

        }

        return res;
    }
}