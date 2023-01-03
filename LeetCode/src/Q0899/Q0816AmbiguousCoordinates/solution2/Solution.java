package Q0899.Q0816AmbiguousCoordinates.solution2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> ambiguousCoordinates(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n - 2; i++) {
            List<String> A = f(s.substring(1, i + 1)), B = f(s.substring(i + 1, n - 1));
            for (String a : A) {
                for (String b : B) {
                    ans.add("(" + a + ", " + b + ")");
                }
            }
        }
        return ans;
    }

    List<String> f(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        if (n == 0 || (n > 1 && s.charAt(0) == '0' && s.charAt(n - 1) == '0')) return ans;
        if (n > 1 && s.charAt(0) == '0') {
            ans.add("0." + s.substring(1));
            return ans;
        }
        ans.add(s);
        if (n == 1 || s.charAt(n - 1) == '0') return ans;
        for (int i = 1; i < n; i++) ans.add(s.substring(0, i) + '.' + s.substring(i));
        return ans;
    }
}