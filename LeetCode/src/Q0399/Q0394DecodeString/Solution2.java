package Q0399.Q0394DecodeString;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Decode String.
public class Solution2 {
    int ind = 0;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while (ind < s.length() && s.charAt(ind) != ']') {
            if (!Character.isDigit(s.charAt(ind))) {
                sb.append(s.charAt(ind++));
            } else {
                int k = 0;
                while (ind < s.length() && Character.isDigit(s.charAt(ind))) {
                    k = k * 10 + s.charAt(ind++) - '0';
                }
                ind++;
                String temp = decodeString(s);
                ind++;

                while (k-- > 0) {
                    sb.append(temp);
                }
            }
        }

        return sb.toString();
    }
}
