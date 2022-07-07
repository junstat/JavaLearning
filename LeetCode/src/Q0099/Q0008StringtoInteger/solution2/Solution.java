package Q0099.Q0008StringtoInteger.solution2;

public class Solution {
    public int myAtoi(String str) {
        int sign = 1, base = 0, i = 0;
        while (i < str.length() && str.charAt(i) == ' ') i++;
        if (i == str.length()) return 0;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            sign = str.charAt(i++) == '-' ? -1 : 1;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 ||
                    (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }
}
