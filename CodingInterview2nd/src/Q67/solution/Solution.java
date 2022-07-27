package Q67.solution;

public class Solution {
    static int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;

    public int StrToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = 0;
        char[] cs = s.toCharArray();
        int n = cs.length;
        while (i < n && cs[i] == ' ') i++;
        if (i == n) return 0;
        int sign = 1, base = 0;
        if (cs[i] == '-' || cs[i] == '+') {
            sign = cs[i++] == '-' ? -1 : 1;
        }
        while (i < n && cs[i] >= '0' && cs[i] <= '9') {
            int a = cs[i++] - '0';
            if (base > MAX / 10 || (base == MAX / 10 && a > MAX % 10))
                return sign == 1 ? MAX : MIN;
            base = 10 * base + a;
        }
        return sign * base;
    }
}
