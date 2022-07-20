package Q0099.Q0044WildcardMatching.solution1;

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