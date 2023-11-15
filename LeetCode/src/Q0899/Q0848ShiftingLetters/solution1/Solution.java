package Q0899.Q0848ShiftingLetters.solution1;

import org.junit.Test;

public class Solution {
    @Test
    public void test1() {
        String s = "abc";
        int[] shifts = {3, 5, 9};
        System.out.println(shiftingLetters(s, shifts));
    }

    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        for (int i = n - 1; i >= 0; i--) {
            shifts[i] %= 26;
            if (i == n - 1) continue;
            shifts[i] += shifts[i + 1];
        }
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            cs[i] = (char) ((cs[i] - 'a' + shifts[i]) % 26 + 'a');
        }
        return String.valueOf(cs);
    }
}
