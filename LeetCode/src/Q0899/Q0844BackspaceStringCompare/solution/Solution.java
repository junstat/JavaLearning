package Q0899.Q0844BackspaceStringCompare.solution;

public class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int i = s.length() - 1, j = t.length() - 1, back;
        while (true) {
            back = 0;
            while (i >= 0 && (back > 0 || cs[i] == '#')) {
                back += cs[i] == '#' ? 1 : -1;
                i--;
            }
            back = 0;
            while (j >= 0 && (back > 0 || ct[j] == '#')) {
                back += ct[j] == '#' ? 1 : -1;
                j--;
            }
            if (i >= 0 && j >= 0 && cs[i] == ct[j]) {
                i--;
                j--;
            } else {
                break;
            }
        }
        return i == -1 && j == -1;
    }
}
