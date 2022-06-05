package Q0499.Q0405ConvertaNumbertoHexadecimal;

public class Solution {
    public String toHex(int num) {
        String hexLetters = "0123456789abcdef";

        if (num == 0) return "0";
        StringBuilder res = new StringBuilder();
        while (num != 0) {
            res.insert(0, hexLetters.charAt(num & 15));
            num >>>= 4;
        }
        return res.toString();
    }
}
