package Q0099.Q0044WildcardMatching;

/*
    同时遍历文本串str和模式串pattern，设工作变量为s，p。对遍历中出现的情况进行分析
    case 1: 匹配单个字符。pattern[p]='?' 或 str[s] == pattern[p]，此时，s与p同时自增。
    case 2: pattern[p] = '*'。记录'*'出现的位置starIndex=p，s开始匹配'*'的位置match=s，p自增。
    case 3: startIndex被标记过，即pattern中出出现过'*'，此时，令p=starIndex+1，s可以继续匹配，s= match+1。
    case 4: 当前p不是'*'，starIndex没有被标记过，最近没有匹配'*'，失配，返回false。
 */
public class Solution {
    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, starIndex = -1, match = 0;
        while (s < str.length()) {
            // advancing both pointer
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*') {
                starIndex = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIndex != -1) {
                p = starIndex + 1;
                s = ++match;
            }
            // current pattern pointer is not start, last pattern pointer was not *
            // characters do not match
            else return false;
        }

        // check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*') p++;

        return p == pattern.length();
    }
}