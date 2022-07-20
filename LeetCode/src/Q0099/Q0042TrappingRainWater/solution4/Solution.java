package Q0099.Q0042TrappingRainWater.solution4;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        Deque<Integer> d = new ArrayDeque<>();
        for (int r = 0; r < n; r++) {
            // 维护一个单减的栈
            while (!d.isEmpty() && height[r] > height[d.peekLast()]) {
                int cur = d.pollLast();  // pop

                if (d.isEmpty()) continue;
                int l = d.peekLast(); // peek
                int w = r - l + 1 - 2;
                int h = Math.min(height[l], height[r]) - height[cur];
                ans += w * h;
            }
            d.addLast(r); // push
        }
        return ans;
    }
}