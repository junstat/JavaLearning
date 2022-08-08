package Q0799.Q0779KthSymbolinGrammar.solution3;

public class Solution {
    public int kthGrammar(int n, int k) {
        return Integer.bitCount(k - 1) & 1;
    }
}
