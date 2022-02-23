package Q0099.Q0010RegularExpressionMatching;

/*
  I. 状态定义
     f[i][j] = s的前i个字符与p中的前j个字符是否能够匹配。

  II. 初始状态
    f[0][0] = true，即两个空字符串是可以匹配的。

  III. 状态转移方程
  对于匹配情况的讨论
  1. 若p[j]是小写字母，则必须在s中匹配一个相同的字母
      f[i][j] = f[i-1][j-1]  if s[i] = p[j] else false
  2. 若p[j]='*'，则对p[j-1]匹配 任意次
      f[i][j] = f[i][j-2]   匹配0次，如 s="ab" p="abc*"
      f[i][j] = f[i-1][j-2] if s[i] = p[j - 1] 匹配1次 ab ab*
      f[i][j] = f[i-2][j-2] if s[i-1]=s[i]=p[j-1] 匹配2次 abb  ab*
      f[i][j] = f[i-3][j-2] if s[i-2]=s[i-1]=s[i]=p[j-1] 匹配3次 abbb ab*
      ...
      穷举在编码实现和效率方面都很不好。

      换个角度考虑 'X*' (X指代任意字母)的模式，匹配过程中，本质上只会有两种情况:
      a. 匹配s末尾的一个字符，将该字符丢弃，使用该模式继续匹配;
      b. 不匹配字符，将该组合丢弃，不再进行匹配
      上面的想法的状态转移方程:
      f[i][j] = f[i-1][j] or f[i][j-2],  if s[i] = p[j-1]
      f[i][j] = f[i][j-2],               if s[i] != p[j-1]
   3. 若p[j] = '.'，则p[j]一定成功匹配s中的任意一个小写字母 f[i][j] = f[i-1][j-1]

   综上，状态转移方程
   f[i][j] =
      if p[j] != '*':
         f[i-1][j-1],   matches(s[i], p[j])
         false,         otherwise
      else:
          f[i-1][j] or f[i][j-2], matches(s[i], p[j-1])
          f[i][j-2],              otherwise

    其中matches(x, y)判断两个字符是否匹配的辅助函数。
    当y='.' 或 y=x时返回true

   IV. 细节
   最终的答案为f[m][n]，其中m和n分别为字符串s和p的长度。字符串下标从0开始，在实现上面，
   状态下标与实际字符串的下标之间要做转换，f[i][j] = s的前i-1个字符与p中的前j-1个字符是否能够匹配。

   在上面的状态转移方程中，如果字符串 p 中包含一个「字符 + 星号」的组合（例如 a*），那么在进行状态转移时，
   会先将 a 进行匹配（当 p[j] 为 a 时），再将 a* 作为整体进行匹配（当 p[j] 为 * 时）。
   然而，在题目描述中，我们必须将 a* 看成一个整体，因此将 a 进行匹配是不符合题目要求的。
   看来我们进行了额外的状态转移，这样会对最终的答案产生影响吗？
 */
public class Solution1 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}