package Q0799.Q0768MaxChunksToMakeSortedII.solution1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = arr.length, ans = 0, mx = arr[0];
        for (int i = n - 1; i >= 0; i--) {
            if (q.isEmpty() || arr[i] <= q.peekFirst()) q.addFirst(arr[i]);
        }
        for (int num : arr) {
            mx = Math.max(mx, num);
            if (q.peekFirst() != num) continue;
            q.pollFirst();
            if (q.isEmpty() || mx <= q.peekFirst()) ++ans;
        }
        return ans;
    }
}
