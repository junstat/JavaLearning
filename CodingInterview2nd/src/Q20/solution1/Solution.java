package Q20.solution1;

public class Solution {
    int idx = 0, n;
    char[] s;

    public boolean isNumeric(String str) {
        if (str == null || str.length() == 0) return false;
        str = str.trim();
        n = str.length();
        if (n == 0) return false;
        s = str.toCharArray();
        boolean numeric = scanInteger();
        if (idx < n && s[idx] == '.') { // 如果出现'.'，则接下来是数字的小数部分
            idx++;
            // 下面用||的原因: 1. 小数可以没有整数部分，如.123; 2. 小数点后可以没有数字，如233.
            // 3. 小数点前后可以都有数字，如233.666。
            numeric = scanUnsignedInteger() || numeric;
        }

        if (idx < n && (s[idx] == 'e' || s[idx] == 'E')) {
            idx++;
            numeric = numeric && scanInteger();
        }
        return numeric && idx == n;
    }

    boolean scanUnsignedInteger() {
        int before = idx;
        while (idx < n && s[idx] >= '0' && s[idx] <= '9') idx++;
        return idx > before;
    }

    boolean scanInteger() {
        if (idx < n) {
            if (s[idx] == '+' || s[idx] == '-') idx++;
            return scanUnsignedInteger();
        }
        return false;
    }
}
