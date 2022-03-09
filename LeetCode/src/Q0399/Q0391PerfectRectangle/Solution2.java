package Q0399.Q0391PerfectRectangle;

import java.util.Set;
import java.util.TreeSet;

public class Solution2 {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<int[]> rectangleSet = new TreeSet<>((r1, r2) -> {
            if (r1[1] >= r2[3] || r1[0] >= r2[2]) {
                return 1;
            } else if (r1[3] <= r2[1] || r1[2] <= r2[0]) {
                return -1;
            } else {
                return 0;
            }
        });
        int top = Integer.MIN_VALUE;
        int bottom = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int area = 0;
        for (int[] rectangle : rectangles) {
            if (!rectangleSet.add(rectangle)) {
                return false;
            }
            area += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
            top = Math.max(top, rectangle[3]);
            bottom = Math.min(bottom, rectangle[1]);
            left = Math.min(left, rectangle[0]);
            right = Math.max(right, rectangle[2]);
        }
        return (right - left) * (top - bottom) == area;
    }
}
