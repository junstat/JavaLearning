package Q0799.Q0767ReorganizeString.solution1;

public class Solution {
    public String reorganizeString(String ss) {
        char[] s = ss.toCharArray();
        int[] cnt = new int[26];
        int n = s.length;
        char[] ans = new char[n];
        for (char c : s) cnt[c - 'a']++;
        for (int i = 0; i < n; i++) {
            int maxIndex = -1;
            for (int j = 0; j < 26; j++) {
                if (cnt[j] == 0 || (i > 0 && ans[i - 1] == j + 'a')) continue;
                if (maxIndex == -1 || cnt[j] > cnt[maxIndex]) maxIndex = j;
            }
            if (maxIndex == -1) return "";
            cnt[maxIndex]--;
            ans[i] = (char) (maxIndex + 'a');
        }
        return new String(ans);
    }
}
