package Q0499.Q0409LongestPalindrome;

public class Solution {
    public int longestPalindrome(String s) {
        int[] occurrence = new int['z' - 'A' + 1];
        for (char c : s.toCharArray()) {
            occurrence[c - 'A']++;
        }

        // keeps track of length
        int sum = 0;

        // add largest odd occurrence to the length
        for (int i = 0; i < 'z' - 'A' + 1; i++) {
            occurrence[i] = occurrence[i] / 2;
            sum = sum + 2 * occurrence[i];
        }

        return s.length() == sum ? sum : sum + 1;
    }
}
