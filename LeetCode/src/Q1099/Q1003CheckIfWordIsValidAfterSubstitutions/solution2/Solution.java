package Q1099.Q1003CheckIfWordIsValidAfterSubstitutions.solution2;

public class Solution {
    public boolean isValid(String ss) {
        var s = ss.toCharArray();
        int i = 0;  // 栈中元素下标，i-1 表示栈顶
        for (var c : s) {
            if (c > 'a' && (i == 0 || c - s[--i] != 1))
                return false;
            if (c < 'c') s[i++] = c;
        }
        return i == 0;
    }
}
