package Q0699.Q0678ValidParenthesisString.solution2;

public class Solution {
    public boolean checkValidString(String s) {
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
                r++;
            } else if (c == ')') {
                l--;
                r--;
            } else {
                l--;
                r++;
            }
            l = Math.max(l, 0);
            if (l > r) return false;
        }
        return l == 0;
    }
}