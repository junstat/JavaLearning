package Q0099.Q0078Subsets;

import java.util.ArrayList;
import java.util.List;

/*
    Bit Manipulation
    To give all the possible subsets, we just need to exhaust all the possible combination of the numbers. And each
    number has only two possibilities: either in or nor in a subset. And this can be represented using a bit.

    Using [1, 2, 3] as an example, 1 appears once in every two consecutive subsets, 2 appears twice in every four
    consecutive subsets, and 3 appears four times in every eight subsets(initially all subsets are empty).
     2 ^ 3 = 8 总共有8个子集
    1 -> 0001
    2 -> 0010
    3 -> 0011
    4 -> 0100
    5 -> 0101
    6 -> 0110
    7 -> 0111

 */
public class Solution2 {

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length, p = 1 << n;
        List<List<Integer>> subs = new ArrayList<>();
        for (int i = 0; i < p; i++) subs.add(new ArrayList<>());

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) > 0) {
                    subs.get(i).add(nums[j]);
                }
            }
        }
        return subs;
    }
}