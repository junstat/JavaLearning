package Q0099.Q0008StringtoInteger;

public class Solution1 {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-' && str.charAt(0) != '+') return 0;
        int res = 0;
        boolean neg = str.charAt(0) == '-';
        int curNumberIndex = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        while (curNumberIndex < str.length() && Character.isDigit(str.charAt(curNumberIndex))) {
            // int型的边界扣除当前数，即当前res的边界
            int tmp = ((neg ? Integer.MIN_VALUE : Integer.MIN_VALUE + 1) + (str.charAt(curNumberIndex) - '0')) / 10;
            if (tmp > res) { // 因为tmp, res均为负，tmp > res <=> abs(tmp) < abs(res)，即当前res已越界
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 - (str.charAt(curNumberIndex++) - '0'); // res  恒为负    1 3 8 -> -12
        }
        return neg ? (int) res : (int) -res;
    }
}
