package Q0699.Q0647PalindromicSubstrings.solution2;

public class Solution {
    public int countSubstrings(String s) {
        String T = preProcess(s);
        int m = s.length(), n = T.length();
        int[] P = new int[n];
        P[1] = 1;
        int j = 1, ans = 0;
        for (int i = 1; i <= 2 * m; i++) {
            int cur = j + P[j] > i ? Math.min(P[2 * j - i], j + P[j] - i) : 1;
            while (T.charAt(i - cur) == T.charAt(i + cur)) ++cur;
            if (i + cur > j + T.charAt(j)) j = i;
            P[i] = cur;
            ans += P[i] / 2;
        }
        return ans;
    }

    String preProcess(String s) {
        int n = s.length();
        if (n == 0) return "^$";
        StringBuilder res = new StringBuilder("^");
        for (int i = 0; i < n; i++) res.append('#').append(s.charAt(i));
        res.append("#$");
        return res.toString();
    }
}