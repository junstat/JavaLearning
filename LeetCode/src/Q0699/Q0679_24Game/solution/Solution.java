package Q0699.Q0679_24Game.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static final double DIFF_TOLERANCE = 0.1;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int num : cards) nums.add((double) num);
        return judgePoint24(nums);
    }

    boolean judgePoint24(List<Double> nums) {
        if (nums.size() == 1) return Math.abs(nums.get(0) - 24) <= DIFF_TOLERANCE;
        else {
            for (int i = 0; i < nums.size(); i++) {
                for (int j = 0; j < i; j++) {
                    double a = nums.get(i), b = nums.get(j);
                    // invariant: no 0 in nums
                    // possible results by adding operator between a and b
                    List<Double> vals = new ArrayList<>(Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a));

                    List<Double> copyNums = new ArrayList<>(nums);
                    copyNums.remove(i);
                    copyNums.remove(j);
                    for (double val : vals) {
                        copyNums.add(val);
                        if (judgePoint24(copyNums)) return true;
                        copyNums.remove(copyNums.size() - 1);
                    }
                }
            }
            return false;
        }
    }
}
