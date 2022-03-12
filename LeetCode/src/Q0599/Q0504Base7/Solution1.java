package Q0599.Q0504Base7;

public class Solution1 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        char sign = '+';
        if (num < 0) {
            num *= -1;
            sign = '-';
        }
        StringBuilder res = new StringBuilder();
        while (num != 0) {
            res.append(num % 7);
            num /= 7;
        }
        if (sign == '-') res.append('-');
        return res.reverse().toString();
    }
}