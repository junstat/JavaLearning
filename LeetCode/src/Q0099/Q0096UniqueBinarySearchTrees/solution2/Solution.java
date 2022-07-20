package Q0099.Q0096UniqueBinarySearchTrees.solution2;

public class Solution {
    public int numTrees(int n) {
        long C = 1;
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2L * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
