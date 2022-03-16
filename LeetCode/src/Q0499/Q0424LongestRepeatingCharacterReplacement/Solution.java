package Q0499.Q0424LongestRepeatingCharacterReplacement;

/*
    sliding window
    There's no edge case for this question. The initial step is to extend the window to its limit, that is, the
    longest we can get to with maximum number of modifications. Until then the variable start will remain at 0.

    Then as end increase, the whole substring from 0 to end will violate the rule, so we need to update start
    accordingly (slide the window). We move start to the right until the whole string satisfy the constraint again.
    Then each time we reach such situation, we update our max length.
 */
public class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < n; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
