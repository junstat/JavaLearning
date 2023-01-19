package Q2299.Q2299StrongPasswordCheckerII.solution;

public class Solution {
    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();
        if (n < 8) return false;
        int mask = 0;
        char[] cs = password.toCharArray();
        for (int i = 0; i < n; i++) {
            if (i > 0 && cs[i] == cs[i - 1]) return false;
            if (Character.isLowerCase(cs[i])) {
                mask |= 1;
            } else if (Character.isUpperCase(cs[i])) {
                mask |= 2;
            } else if (Character.isDigit(cs[i])) {
                mask |= 4;
            } else {
                mask |= 8;
            }
        }
        return mask == 15;
    }
}

