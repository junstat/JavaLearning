package Q0399.Q0344ReverseString.solution;

public class Solution {
    public void reverseString(char[] s) {
        for (int start = 0, end = s.length - 1; start < end; start++, end--) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
        }
    }
}
