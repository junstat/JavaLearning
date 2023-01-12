package Q2299.Q2287RearrangeCharacterstoMakeTargetString.solution;

public class Solution {
    public int rearrangeCharacters(String s, String t) {
        int[] cntS = new int[26];
        int[] cntT = new int[26];
        for (char c : s.toCharArray()) {
            cntS[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cntT[c - 'a']++;
        }
        int ans = s.length();
        for (int i = 0; i < 26; i++) {
            int cnt = cntS[i];
            if (cntT[i] > 0) {
                ans = Math.min(ans, cnt / cntT[i]);
            }
        }
        return ans;
    }
}
