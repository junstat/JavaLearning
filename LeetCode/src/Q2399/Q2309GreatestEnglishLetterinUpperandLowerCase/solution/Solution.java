package Q2399.Q2309GreatestEnglishLetterinUpperandLowerCase.solution;

public class Solution {
    public String greatestLetter(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        boolean[] lSeen = new boolean[26], uSeen = new boolean[26];
        for (char c : cs) {
            if (Character.isUpperCase(c)) {
                uSeen[c - 'A'] = true;
            } else {
                lSeen[c - 'a'] = true;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (lSeen[i] && uSeen[i]) return String.valueOf((char) ('A' + i));
        }
        return "";
    }
}
