package Q0099.Q0003.solution4;

import java.util.Arrays;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0 || n == 1) return n;
        int[] lastOccurred = new int[128];
        Arrays.fill(lastOccurred, -1);
        int res = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char right = s.charAt(end);
            if (lastOccurred[right] >= start) // 发生了重复
                start = lastOccurred[right] + 1;
            res = Math.max(res, end - start + 1);
            lastOccurred[right] = end;
        }
        return res;
    }
}
