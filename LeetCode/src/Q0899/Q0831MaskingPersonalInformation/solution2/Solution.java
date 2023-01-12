package Q0899.Q0831MaskingPersonalInformation.solution2;

public class Solution {
    public String maskPII(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        if (s.contains("@")) return maskEmail(cs, n);
        return maskPhone(cs, n);
    }

    String maskPhone(char[] cs, int n) {
        int cnt = 0, i = 0;
        for (char c : cs) {
            cnt += Character.isDigit(c) ? 1 : 0;
        }
        String ans = "";
        if (cnt > 10) {
            ans += "+";
            for (; cnt > 10; i++) {
                if (!Character.isDigit(cs[i])) continue;
                --cnt;
                ans += "*";
            }
            ans += "-";
        }
        for (; cnt > 0; i++) {
            if (!Character.isDigit(cs[i])) continue;
            --cnt;
            if (cnt > 3) ans += "*";
            else ans += cs[i];
            if (cnt == 7 || cnt == 4) ans += "-";
        }
        return ans;
    }

    String maskEmail(char[] cs, int n) {
        String ans = "";
        ans += Character.toLowerCase(cs[0]);
        for (int i = 0; i < 5; i++) ans += "*";
        int i = 0;
        while (i + 1 < n && cs[i + 1] != '@') ++i;
        for (; i < n; i++) ans += Character.toLowerCase(cs[i]);
        return ans;
    }
}
