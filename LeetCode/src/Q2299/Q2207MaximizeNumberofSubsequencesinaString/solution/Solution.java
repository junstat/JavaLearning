package Q2299.Q2207MaximizeNumberofSubsequencesinaString.solution;

public class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long ans = 0, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == pattern.charAt(1)) {
                ans += cnt1;
                cnt2++;
            }
            if (text.charAt(i) == pattern.charAt(0)) cnt1++;
        }
        return ans + Math.max(cnt1, cnt2);
    }
}
