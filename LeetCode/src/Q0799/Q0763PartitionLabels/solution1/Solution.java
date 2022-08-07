package Q0799.Q0763PartitionLabels.solution1;

import java.util.ArrayList;
import java.util.List;

// Solution 1: Counting + Bitmask
public class Solution {
    public List<Integer> partitionLabels(String ss) {
        int[] cnt = new int[26];
        char[] s = ss.toCharArray();
        for (char c : s) cnt[c - 'a']++;
        List<Integer> ans = new ArrayList<>();
        int n = s.length;
        for (int i = 0, pre = 0; i < n; ) {
            int mask = 0;  // `mask` is a bitmask representing all the characters that we've seen in the current
            // range and haven't exhausted all their occurrences.
            do {
                int key = s[i++] - 'a';
                cnt[key]--;
                mask |= 1 << key;
                if (cnt[key] == 0) mask ^= 1 << key; // If we've exhausted this character, remove it from the mask
            } while (mask != 0); // When `mask != 0`, there are still some characters that have remaining occurrence
            // -- we keep looping
            ans.add(i - pre);
            pre = i;
        }
        return ans;
    }
}
