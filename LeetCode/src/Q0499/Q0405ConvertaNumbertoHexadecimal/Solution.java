package Q0499.Q0405ConvertaNumbertoHexadecimal;

/*
Basic idea: each time we take a look at the last four digits of
            binary version of the input, and maps that to a hex char
            shift the input to the right by 4 bits, do it again
            until input becomes 0.
*/
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
