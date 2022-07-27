package Q50.solution;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        char[] cs = str.toCharArray();
        int n = cs.length;
        int[] cnt = new int[128];
        for (char c : cs) cnt[c - 'A']++;
        for (int i = 0; i < n; i++) if (cnt[cs[i] - 'A'] == 1) return i;
        return -1;
    }
}
