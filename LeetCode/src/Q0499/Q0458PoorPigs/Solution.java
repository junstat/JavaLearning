package Q0499.Q0458PoorPigs;

// https://leetcode.com/problems/poor-pigs/discuss/94266/Another-explanation-and-solution
public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        while (Math.pow(minutesToTest / minutesToDie + 1, pigs) < buckets)
            pigs += 1;
        return pigs;
    }
}