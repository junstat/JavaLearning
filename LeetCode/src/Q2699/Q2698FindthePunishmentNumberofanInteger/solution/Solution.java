package Q2699.Q2698FindthePunishmentNumberofanInteger.solution;

public class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for (int num = 1; num <= n; num++) {
            int sqr = num * num;
            String sqrStr = String.valueOf(sqr);
            sum += canPartition(sqrStr.toCharArray(), 0, num) ? sqr : 0;
        }
        return sum;
    }

    private boolean canPartition(char[] s, int startIndex, int target) {
        if (startIndex == s.length && target == 0) return true;
        if (target < 0) return false;
        boolean ans = false;
        int leftNum = 0;
        for (int i = startIndex; i < s.length; i++) {
            leftNum = (leftNum * 10) + (s[i] - '0');
            boolean isPossible = canPartition(s, i + 1, target - leftNum);
            if (isPossible) return true;
        }
        return ans;
    }
}