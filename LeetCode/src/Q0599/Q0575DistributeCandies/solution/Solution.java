package Q0599.Q0575DistributeCandies.solution;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i : candyType) set.add(i);
        return Math.min(candyType.length / 2, set.size());
    }
}