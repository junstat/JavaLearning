package Q0099.Q0038CountAndSay;

public class Solution {
    static String[] f = new String[35];

    static {
        f[1] = "1";
        for (int i = 2; i < 35; i++) {
            String prev = f[i - 1], cur = "";
            int m = prev.length();
            for (int j = 0; j < m; ) {
                int k = j + 1;
                while (k < m && prev.charAt(j) == prev.charAt(k)) k++;
                int cnt = k - j;
                cur += cnt + "" + prev.charAt(j);
                j = k;
            }
            f[i] = cur;
        }
    }

    public String countAndSay(int n) {
        return f[n];
    }
}