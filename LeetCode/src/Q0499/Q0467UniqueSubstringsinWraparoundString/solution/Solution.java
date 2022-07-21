package Q0499.Q0467UniqueSubstringsinWraparoundString.solution;

public class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        char[] cs = p.toCharArray();
        int max = 0;
        for (int i = 0; i < cs.length; i++) {
            if (i > 0 && (cs[i] - cs[i - 1] == 1 || cs[i] - cs[i - 1] == -25)) max++;
            else max = 1;
            dp[cs[i] - 'a'] = Math.max(max, dp[cs[i] - 'a']);
        }
        int sum = 0;
        for (int i : dp) sum += i;
        return sum;
    }
}
