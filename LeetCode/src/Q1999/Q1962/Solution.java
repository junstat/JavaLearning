package Q1999.Q1962;

import java.util.PriorityQueue;

public class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int ans = 0;
        for (int num : piles) {
            queue.add(num);
            ans += num;
        }
        while (k-- > 0) {
            int a = queue.poll();
            queue.add(a - a / 2);
            ans -= a / 2;
        }
        return ans;
    }
}