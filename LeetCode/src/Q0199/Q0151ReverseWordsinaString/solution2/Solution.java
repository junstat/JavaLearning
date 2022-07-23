package Q0199.Q0151ReverseWordsinaString.solution2;

public class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;

        char[] chars = s.toCharArray();
        int n = chars.length;

        reverse(chars, 0, n - 1);
        reverseWords(chars, n);
        return cleanSpaces(chars, n);
    }

    private String cleanSpaces(char[] chars, int n) {
        int start = 0, end = 0;
        while (end < n) {
            while (end < n && chars[end] == ' ') end++;
            while (end < n && chars[end] != ' ') chars[start++] = chars[end++];
            while (end < n && chars[end] == ' ') end++;
            if (end < n) chars[start++] = ' ';
        }
        return new String(chars).substring(0, start);
    }

    private void reverseWords(char[] chars, int n) {
        int start = 0, end = 0;
        while (start < n) {
            while (start < end || start < n && chars[start] == ' ') start++;
            while (end < start || end < n && chars[end] != ' ') end++;
            reverse(chars, start, end - 1);
        }
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }
}