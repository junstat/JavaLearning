package Q0099.Q0010RegularExpressionMatching;

public class Solution1 {
    public boolean isMatch(String ss, String pp) {
        // 技巧: 往原字符串头部插入空格，这样得到的char数组是从1开始，而且可以使用f[0][0]=true,可以将true这个结果滚动下去
        int n = ss.length(), m = pp.length();
        ss = " " + ss;
        pp = " " + pp;
        char[] s = ss.toCharArray(), p = pp.toCharArray();
        // f(i, j) 代表考虑s中的1~i字符和p中的1~j字符是否匹配
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 如果下一个字符是'*'，则代表当前字符不能被单独使用，跳过
                if (j + 1 <= m && p[j + 1] == '*') continue;
                if (i - 1 >= 0 && p[j] != '*') {
                    // 对应了p[j]为普通字符和'.'的两种情况
                    f[i][j] = f[i - 1][j - 1] && (s[i] == p[j] || p[j] == '.');
                } else if (p[j] == '*') {
                    // 对应了p[j] 为 '*'的情况
                    f[i][j] = (j - 2 >= 0 && f[i][j - 2]) ||
                            (i - 1 >= 0 && f[i - 1][j] && (s[i] == p[j - 1] || p[j - 1] == '.'));
                }
            }
        }
        return f[n][m];
    }
}