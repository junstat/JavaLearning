package Q0499.Q0492ConstructtheRectangle.solution;

public class Solution {
    public int[] constructRectangle(int area) {
        for (int i = (int)(Math.sqrt(area)); ;i--) {
            if (area % i == 0) return new int[]{area / i, i};
        }
    }
}