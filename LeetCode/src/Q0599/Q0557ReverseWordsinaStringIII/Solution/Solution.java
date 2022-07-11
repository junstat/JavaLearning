package Q0599.Q0557ReverseWordsinaStringIII.Solution;

public class Solution {
    public String reverseWords(String s) {
        char[] sc = s.toCharArray();
        int n = sc.length;
        for (int i = 0, begin = 0; i <= n; i++) {
            if (i == n || sc[i] == ' ') {
                reverse(sc, begin, i - 1);
                begin = i + 1;
            }
        }
        return new String(sc);
    }

    void reverse(char[] sc, int i, int j) {
        for (int l = i, r = j; l < r; l++, r--) {
            char c = sc[l];
            sc[l] = sc[r];
            sc[r] = c;
        }
    }
}
