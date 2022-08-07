package Q0799.Q0767ReorganizeString.solution2;

import java.util.PriorityQueue;

// Greedy + Heap
public class Solution {
    public String reorganizeString(String ss) {
        char[] s = ss.toCharArray();
        int[] cnt = new int[26];
        int n = s.length, pre = -1;
        for (char c : s) cnt[c - 'a']++;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (cnt[b] - cnt[a]));
        for (int i = 0; i < 26; i++) if (cnt[i] != 0) q.add(i);
        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()) {
            int c = q.poll();
            ans.append((char) ('a' + c));
            if (pre != -1) q.add(pre);
            if (--cnt[c] != 0) pre = c;
            else pre = -1;
        }
        if (pre != -1) return "";
        return ans.toString();
    }
}
