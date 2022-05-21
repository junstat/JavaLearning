package Q0499.Q0447NumberofBoomerangs;

import java.util.HashMap;
import java.util.Map;

// Runtime: 53 ms, faster than 100.00% of Java online submissions for Number of Boomerangs.
public class Solution2 {
    public int numberOfBoomerangs(int[][] points) {
        //distance formula: d = sqrt((x2-x1)^2 + (y2-y1)^2)
        int boomerangs = 0;

        //distance map: key = distance, value = how many distances recorded
        Map<Integer, Integer> map = new HashMap<>();

        //calculate distances
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue; //skip diagonal in the distance matrix
                }
                int dist = distance(points[i], points[j]);
                int matchingPoints = 0;
                if (map.get(dist) != null) {
                    matchingPoints = map.get(dist);
                    if (matchingPoints > 0) {
                        boomerangs += matchingPoints * 2; //there will always be 2 different orderings of the same 3 points
                    }
                }
                matchingPoints++;
                map.put(dist, matchingPoints);
            }
            map.clear();
        }

        return boomerangs;

    }

    public int distance(int[] p1, int[] p2) { //remove sqrt - remove need for distance to be a double
        int xDiff = p1[0] - p2[0];
        int yDiff = p1[1] - p2[1];
        int difference = (xDiff * xDiff) + (yDiff * yDiff);
        return difference;
    }
}
