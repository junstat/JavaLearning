package Q0099.Q0052NQueensII.solution2;

public class Solution {
    public int totalNQueens(int n) {
        return solve(n, 0, 0, 0, 0);
    }

    private int solve(int n, int row, int col, int d1, int d2) {
        if (row == n)
            return 1;
        int count = 0;
        int availablePositions = ((1 << n) - 1) & (~(col | d1 | d2));
        // availablePositions 还有哪些位置可以用
        while (availablePositions != 0) {
            // position: 找到availablePositions中的最低位1
            int position = availablePositions & (-availablePositions);
            // postion已经被使用，最低位1置为不可用
            availablePositions = availablePositions & (availablePositions - 1);
            count += solve(n, row + 1, col | position, (d1 | position) << 1, (d2 | position) >> 1);
        }
        return count;
    }
}