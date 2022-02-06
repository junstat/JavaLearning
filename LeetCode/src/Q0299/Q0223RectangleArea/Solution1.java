package Q0299.Q0223RectangleArea;

public class Solution1 {
    //                          A        B        C        D        E       F        G          H
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1), area2 = (bx2 - bx1) * (by2 - by1);
        if (bx1 >= ax2 || bx2 <= ax1 || by1 >= ay2 || by2 <= ay1)   // 没有重叠
            return area1 + area2;
        int coverX = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int coverY = Math.min(ay2, by2) - Math.max(ay1, by1);
        return area1 + area2 - coverX * coverY;
    }
}
