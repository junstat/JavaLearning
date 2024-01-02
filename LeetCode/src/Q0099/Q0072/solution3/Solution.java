package Q0099.Q0072.solution3;

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length(), pre;
        int[] cur = new int[n + 1];
        for (int i = 1; i <= n; i++) cur[i] = i;
        for (int i = 1; i <= m; i++) {
            pre = cur[0];
            cur[0] = i;
            for (int j = 1; j <= n; j++) {
                int temp = cur[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[j] = pre;
                } else {
                    cur[j] = Math.min(pre, Math.min(cur[j - 1], cur[j])) + 1;
                }
                pre = temp;
            }
        }
        return cur[n];
    }
}