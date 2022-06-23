package Q0099.Q0003LongestSubstringWithoutRepeatingCharacters;

public class Solution4 {
    public int lengthOfLongestSubstring(String s) {
        int[] lastOccurred = new int[128];
        int res = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            if (lastOccurred[s.charAt(end)] >= start) start = lastOccurred[s.charAt(end)] + 1;
            res = Math.max(res, end - start + 1);
            lastOccurred[s.charAt(end)] = end;
        }
        return res;
    }
}
