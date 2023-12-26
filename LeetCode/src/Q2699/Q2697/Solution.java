package Q2699.Q2697;

public class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] == chars[j]) {
                continue;
            }
            chars[j] = chars[i] = (char) Math.min(chars[i], chars[j]);
        }
        return new String(chars);
    }
}