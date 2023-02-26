package Q0899.Q0870AdvantageShuffle.solution2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int n = A.length;
        int[] ans = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{B[i], i});
        }
        int lo = 0, hi = n - 1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int idx = cur[1], val = cur[0];
            if (A[hi] > val) ans[idx] = A[hi--];
            else ans[idx] = A[lo++];
        }
        return ans;
    }
}