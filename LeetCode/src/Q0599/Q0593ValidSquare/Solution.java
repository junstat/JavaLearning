package Q0599.Q0593ValidSquare;

import java.util.Arrays;
import java.util.HashSet;

/*
    If we calculate all distances between 4 points, 4 smaller distances should be equal (sides), and 2 larger
    distances should be equal too (diagonals). As an optimization, we can compare squares of the distances, so we do
    not have to deal with the square root and precision loss.
    Therefore, our set will only contain 2 unique distances in case of square (beware of the zero distance though).
 */
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> hs = new HashSet<>(Arrays.asList(d(p1, p2), d(p1, p3), d(p1, p4), d(p2, p3), d(p2, p4),
                d(p3, p4)));
        return !hs.contains(0) && hs.size() == 2;   // One each for side & diagonal
    }

    public int d(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}