package Q0499.Q0464CanIWin;

import java.util.HashMap;
import java.util.Map;

/*
    For short notation, let M = maxChoosableInteger and T = desiredTotal.

    Key Observation: the state of the game is completely determined by currently available numbers to pick in the
    common pool.

    State of Game: initially, we have all M numbers [1, M] available in the pool. Each number may or may not be
    picked at a state of the game later on, so we have maximum 2^M different states. Note that M <= 20, so int range
    is enough to cover it. For memorization, we define int k as the key for a game state, where

    the i-th bit of k, i.e., k&(1<<i) represents the availability of number i+1 (1: picked; 0: not picked).
    At state k, the current player could pick any unpicked number from the pool, so state k can only go to one of the
     valid next states k':

    if i-th bit of k is 0, set it to be 1, i.e., next state k' = k|(1<<i).
    Recursion: apparently

    the current player can win at state k iff opponent can't win at some valid next state k'.
    Memorization: to speed up the recursion, we can use a vector<int> m of size 2^M to memorize calculated results
    m[k] for state key k:

    0 : not calculated yet;
    1 : current player can win;
    -1: current player can't win.
    Initial State Check:
    There are several checks to be done at initial state k = 0 for early termination so we won't waste our time for
    DFS process:

    if T < 2, obviously, the first player wins by simply picking 1.
    if the sum of entire pool S = M*(M+1)/2 is less than T, of course, nobody can reach T.
    if the sum S == T, the order to pick numbers from the pool is irrelevant. Whoever picks the last will reach T. So
     the first player can win iff M is odd.
 */
public class Solution {
    int[] m;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (desiredTotal <= maxChoosableInteger)
            return true;
        if (sum < desiredTotal)
            return false;
        if (sum == desiredTotal)
            return maxChoosableInteger % 2 == 1;
        m = new int[1 << 20];
        return dfs(maxChoosableInteger, desiredTotal, 0);
    }

    private boolean dfs(int M, int T, int k) {
        if (T <= 0 || m[k] != 0)
            return T > 0 && m[k] > 0;

        for (int i = 0; i < M; i++) {
            if ((k & (1 << i)) == 0 && !dfs(M, T - i - 1, k | (1 << i))) {
                m[k] = 1;
                return true;
            }
        }
        m[k] = -1;
        return false;
    }
}