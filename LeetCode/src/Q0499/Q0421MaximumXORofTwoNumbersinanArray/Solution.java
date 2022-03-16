package Q0499.Q0421MaximumXORofTwoNumbersinanArray;

import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/solution/shu-zu-zhong-liang-ge-shu-de-zui-da-yi-h-n9m9/
public class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxResult = 0;
        int mask = 0;

        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums)
                set.add(num & mask);

            int greedyTry = maxResult | (1 << i);
            for (int prefix : set) {
                if (set.contains(greedyTry ^ prefix)) {
                    maxResult = greedyTry;
                    break;
                }
            }
        }
        return maxResult;
    }
}