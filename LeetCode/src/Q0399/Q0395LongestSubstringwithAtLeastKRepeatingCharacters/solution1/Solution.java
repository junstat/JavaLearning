package Q0399.Q0395LongestSubstringwithAtLeastKRepeatingCharacters.solution1;

import java.util.Arrays;

public class Solution {

    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] counts = new int[26];
        int idx, res = 0;

        for (int h = 1; h <= 26; h++) {
            Arrays.fill(counts, 0);
            int i = 0, j = 0, unique = 0, noLessThanK = 0;
            while (j < str.length) {
                if (unique <= h) {
                    idx = str[j] - 'a';
                    if (counts[idx] == 0) unique++;
                    counts[idx]++;
                    if (counts[idx] == k) noLessThanK++;
                    j++;
                } else {
                    idx = str[i] - 'a';
                    if (counts[idx] == k) noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0) unique--;
                    i++;
                }
                if (unique == h && unique == noLessThanK)
                    res = Math.max(res, j - i);
            }
        }
        return res;
    }
}