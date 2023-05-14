package Q2299.Q2215FindtheDifferenceofTwoArrays.solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var seen = new int[2001];
        List<Integer> d1 = new ArrayList<>(), d2 = new ArrayList<>();
        for (int i : nums1) seen[i + 1000] |= 1;
        for (int i : nums2) seen[i + 1000] |= 2;
        for (int i = 0; i < seen.length; i++) {
            if (seen[i] == 1) d1.add(i - 1000);
            else if (seen[i] == 2) d2.add(i - 1000);
        }
        return Arrays.asList(d1, d2);
    }
}
