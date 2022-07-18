package Q0499.Q0406QueueReconstructionbyHeight.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
    1. Pick out tallest group of people and sort them in a subarray (S). Since there's no other groups of people taller
     than them, therefore each guy's index will be just as same as his k value.
    2. For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // pick up the tallest guy first
        // when insert the next tall guy, just need to insert him into kth position
        // repeat until all people are inserted into list
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? -o1[0] + o2[0] : o1[1] - o2[1]);
        List<int[]> res = new LinkedList<>();
        for (int[] cur : people)
            res.add(cur[1], cur);
        return res.toArray(new int[people.length][]);
    }
}
