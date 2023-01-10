package Q0799.Q0753CrackingtheSafe.solution2;

import java.util.Arrays;

public class Solution {
    public String crackSafe(int n, int k) {
        int m = (int) Math.pow(k, n - 1);
        int ms = (int) Math.pow(k, n);
        char[] ans = new char[ms + n - 1];
        int yan = (int) Math.pow(10, n - 1);
        int[] mp = new int[yan];
        Arrays.fill(mp, k - 1);
        if (n == 1) {
            for (int i = 0; i < k; i++) {
                ans[i] = (char) ('0' + i);
            }
            return new String(ans);
        }
        int i = 0;
        for (; i < n - 1; i++) {
            ans[i] = '0';
        }
        int node = 0;
        for (; i < ans.length; i++) {
            ans[i] = (char) ('0' + mp[node]);
            node = (node * 10) % yan + mp[node]--;
        }
        return new String(ans);
    }
}