package Q0799.Q0779KthSymbolinGrammar.solution1;

public class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        return k <= (1 << (n - 2)) ? kthGrammar(n - 1, k) : (1 - kthGrammar(n - 1, k - (1 << (n - 2))));
    }
}
