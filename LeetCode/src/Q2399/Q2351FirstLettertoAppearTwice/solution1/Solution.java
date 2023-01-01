package Q2399.Q2351FirstLettertoAppearTwice.solution1;

public class Solution {
    public char repeatedCharacter(String s) {
        boolean[] mp = new boolean[26];
        for (char c : s.toCharArray()) {
            if (mp[c - 'a']) return c;
            mp[c - 'a'] = true;
        }
        return 0;
    }
}