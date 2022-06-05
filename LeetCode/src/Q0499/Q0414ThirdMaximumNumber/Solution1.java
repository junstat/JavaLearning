package Q0499.Q0414ThirdMaximumNumber;

import java.util.*;

public class Solution1 {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) set.add(num);
        List<Integer> sortedNums = new ArrayList<>(set);
        Collections.sort(sortedNums);
        return sortedNums.size() < 3 ? sortedNums.get(sortedNums.size() - 1) : sortedNums.get(sortedNums.size() - 3);
    }
}
