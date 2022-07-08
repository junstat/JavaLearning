package Q0099.Q0013RomanToInteger.solution1;

public class Solution {

    public int romanToInt(String s) {
        int res = 0;
        int pre = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = toNumber(s.charAt(i));
            if (cur >= pre) {
                res += cur;
            } else {
                res -= cur;
            }
            pre = cur;
        }
        return res;
    }

    private int toNumber(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}