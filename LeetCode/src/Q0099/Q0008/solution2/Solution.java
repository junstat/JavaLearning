package Q0099.Q0008.solution2;

public class Solution {
    // INT_MAX: 2147483647
    static int INT_MAX = Integer.MAX_VALUE, INT_MIN = Integer.MIN_VALUE;

    public int myAtoi(String ss) {
        int sign = 1, base = 0, i = 0;
        char[] s = ss.toCharArray();
        while (i < s.length && s[i] == ' ') i++;
        if (i == s.length) return 0;
        if (s[i] == '-' || s[i] == '+') sign = s[i++] == '-' ? -1 : 1;
        while (i < s.length && s[i] >= '0' && s[i] <= '9') {
            int a = s[i++] - '0';
            if (base > INT_MAX / 10 || (base == INT_MAX / 10 && a > INT_MAX % 10))
                return sign == 1 ? INT_MAX : INT_MIN;
            base = 10 * base + a;
        }
        return base * sign;
    }
}
