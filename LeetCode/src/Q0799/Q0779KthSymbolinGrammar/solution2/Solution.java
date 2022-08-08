package Q0799.Q0779KthSymbolinGrammar.solution2;

public class Solution {
    public int kthGrammar(int n, int k) {
        int ans = 0;
        for (; n > 1; --n) {
            if (k > (1 << (n - 2))) {
                ans = 1 - ans;
                k -= (1 << (n - 2));
            }
        }
        return ans;
    }
}
