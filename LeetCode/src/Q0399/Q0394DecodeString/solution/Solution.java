package Q0399.Q0394DecodeString.solution;

public class Solution {
    int idx = 0;

    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        while (idx < s.length() && s.charAt(idx) != ']') {
            if (!Character.isDigit(s.charAt(idx))) ans.append(s.charAt(idx++));
            else {
                int k = 0;
                while (idx < s.length() && Character.isDigit(s.charAt(idx)))
                    k = k * 10 + s.charAt(idx++) - '0';
                idx++; // for '['
                String pre = decodeString(s);
                idx++;  // for ']'

                while (k-- > 0) ans.append(pre);
            }
        }
        return ans.toString();
    }
}