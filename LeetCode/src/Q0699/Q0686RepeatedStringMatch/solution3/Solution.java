package Q0699.Q0686RepeatedStringMatch.solution3;

public class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) sb.append(a);
        sb.append(a);
        int idx = strHash(sb.toString(), b);
        if (idx == -1) return -1;
        return idx + b.length() > a.length() * ans ? ans + 1 : ans;
    }

    int strHash(String ss, String b) {
        int P = 131;
        int n = ss.length(), m = b.length();
        String str = ss + b;
        int len = str.length();
        int[] h = new int[len + 10], p = new int[len + 10];
        h[0] = 0;
        p[0] = 1;
        for (int i = 0; i < len; i++) {
            p[i + 1] = p[i] * P;
            h[i + 1] = h[i] * P + str.charAt(i);
        }
        int r = len, l = r - m + 1;
        int target = h[r] - h[l - 1] * p[r - l + 1]; // b 的哈希值
        for (int i = 1; i <= n; i++) {
            int j = i + m - 1;
            int cur = h[j] - h[i - 1] * p[j - i + 1]; // 子串哈希值
            if (cur == target) return i - 1;
        }
        return -1;
    }
}