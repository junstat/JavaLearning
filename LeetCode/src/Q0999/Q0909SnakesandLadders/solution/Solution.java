package Q0999.Q0909SnakesandLadders.solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    int n;
    int[] nums;

    public int snakesAndLadders(int[][] board) {
        n = board.length;
        if (board[0][0] != -1) return -1;
        nums = new int[n * n + 1];
        boolean isRight = true;
        for (int i = n - 1, idx = 1; i >= 0; i--) {
            for (int j = (isRight ? 0 : n - 1); isRight ? j < n : j >= 0; j += isRight ? 1 : -1) {
                nums[idx++] = board[i][j];
            }
            isRight = !isRight;
        }
        int ans = bfs();
        return ans;
    }

    int bfs() {
        Deque<Integer> d = new ArrayDeque<>();
        Map<Integer, Integer> m = new HashMap<>();
        d.addLast(1);
        m.put(1, 0);
        while (!d.isEmpty()) {
            int poll = d.pollFirst();
            int step = m.get(poll);
            if (poll == n * n) return step;
            for (int i = 1; i <= 6; i++) {
                int np = poll + i;
                if (np <= 0 || np > n * n) continue;
                if (nums[np] != -1) np = nums[np];
                if (m.containsKey(np)) continue;
                m.put(np, step + 1);
                d.addLast(np);
            }
        }
        return -1;
    }
}