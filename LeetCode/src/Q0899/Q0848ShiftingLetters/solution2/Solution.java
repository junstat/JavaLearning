package Q0899.Q0848ShiftingLetters.solution2;

public class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        char[] cs = s.toCharArray();
        int offset = 0;
        for (int i = n - 1; i >= 0; i--) {
            shifts[i] %= 26;
            offset = (offset  +shifts[i]) % 26;
            cs[i] = (char) ((cs[i]- 'a' + offset) % 26 + 'a');
        }
        return String.valueOf(cs);
    }
}
