package Q1299.Q1238CircularPermutationinBinaryRepresentation.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>(1 << n);
        for (int i = 0; i < (1 << n); i++) {
            ans.add(i ^ (i >> 1) ^ start);
        }
        return ans;
    }
}
