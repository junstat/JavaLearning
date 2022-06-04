package Q0399.Q0394DecodeString;

public class Solution {
    int ind = 0;

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        while (ind < s.length() && s.charAt(ind) != ']') {
            if (!Character.isDigit(s.charAt(ind))) {
                res.append(s.charAt(ind++));
            } else {
                int k = 0;
                while (ind < s.length() && Character.isDigit(s.charAt(ind))) {
                    k = k * 10 + s.charAt(ind++) - '0';
                }
                ind++;  // for '['
                String pre = decodeString(s);
                ind++;  // for ']'

                while (k-- > 0) {
                    res.append(pre);
                }
            }
        }

        return res.toString();
    }
}
