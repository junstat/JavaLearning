package Q0399.Q0394DecodeString.solution;

public class Solution {
    int idx = 0;

    public String decodeString(String ss) {
        StringBuilder ans = new StringBuilder();
        char[] s = ss.toCharArray();
        int n = s.length;
        while (idx < n && s[idx] != ']') {
            if (!Character.isDigit(s[idx])) ans.append(s[idx++]);
            else {
                int k = 0;
                while (idx < n && Character.isDigit(s[idx]))
                    k = k * 10 + s[idx++] - '0';
                idx++;  // for '['
                String pre = decodeString(ss);
                idx++;  // for ']'
                while (k-- > 0) ans.append(pre);
            }
        }
        return ans.toString();
    }
}