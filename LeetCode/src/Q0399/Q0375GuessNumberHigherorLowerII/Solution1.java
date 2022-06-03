package Q0399.Q0375GuessNumberHigherorLowerII;

/*
    For each number x in range[i~j]
    we do: result_when_pick_x = x + max{DP([i~x-1]), DP([x+1, j])}
    --> // the max means whenever you choose a number, the feedback is always bad and therefore leads you to a worse
    branch.
    then we get DP([i~j]) = min{xi, ... ,xj}
    --> // this min makes sure that you are minimizing your cost.
 */
public class Solution1 {
    private int[][] dp;

    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        return getMoneyAmountAux(1, n);
    }

    int getMoneyAmountAux(int s, int e) {
        if (s >= e) return 0;
        if (dp[s][e] != 0) return dp[s][e];
        int res = Integer.MAX_VALUE;
        for (int x = s; x <= e; x++) {
            int maxEndHere = x + Math.max(getMoneyAmountAux(s, x - 1), getMoneyAmountAux(x + 1, e));
            res = Math.min(res, maxEndHere);
        }
        dp[s][e] = res;
        return res;
    }
}