package Q0599.Q0567PermutationinString.solution;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) return false;
        int[] cnt = new int[26];
        for (char c : s1.toCharArray()) cnt[c - 'a']++;
        int[] cur = new int[26];
        for (int i = 0; i < m; i++) cur[s2.charAt(i) - 'a']++;
        if (check(cnt, cur)) return true;
        for (int i = m; i < n; i++) {
            cur[s2.charAt(i) - 'a']++;
            cur[s2.charAt(i - m) - 'a']--;
            if (check(cnt, cur)) return true;
        }
        return false;
    }
    boolean check(int[] cnt1, int[] cnt2) {
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }
}