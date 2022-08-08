package Q0199.Q0128LongestConsecutiveSequence.solution;

import java.util.HashMap;

public class Solution {

    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> ranges = new HashMap<>();
        for (int n : nums) {
            if (ranges.containsKey(n)) continue;
            // 1. Find left and right num
            int left = ranges.getOrDefault(n - 1, 0);
            int right = ranges.getOrDefault(n + 1, 0);
            int sum = left + right + 1;
            ranges.put(n, sum);  // Keep each number in Map to de-duplicate
            res = Math.max(res, sum);

            // 2. Union by only updating boundary
            // Leave middle k-v dirty to avoid cascading update
            if (left > 0) ranges.put(n - left, sum);
            if (right > 0) ranges.put(n + right, sum);
        }
        return res;
    }
}

/*
漂亮的cpp解法
use a hash map to store boundary information of consecutive sequence for each element; there are 4 cases when a new
element i reached:
1) neither i+1 nor i-1 has been seen: m[i]=1;
2) both i+1 and i-1 have been seen: extend m[i+m[i+1]] and m[i-m[i-1]] to each other;
3) only i+1 has been seen: extend m[i+m[i+1]] and m[i] to each other;
4) only i-1 has been seen: extend m[i-m[i-1]] and m[i] to each other.

int longestConsecutive(vector<int> &num) {
    unordered_map<int, int> m;
    int r = 0;
    for (int i : num) {
        if (m[i]) continue;
        r = max(r, m[i] = m[i + m[i + 1]] = m[i - m[i - 1]] = m[i + 1] + m[i - 1] + 1);
    }
    return r;
}
 */