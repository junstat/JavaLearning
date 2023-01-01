package Q2399.Q2351FirstLettertoAppearTwice.solution2;

public class Solution {
    public char repeatedCharacter(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            int t = 1 << (c - 'a');
            if ((mask & t) != 0) return c;
            mask |= t;
        }
        return 0;
    }
}