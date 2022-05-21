package Q0499.Q0476NumberComplement;

public class Solution {
    public int findComplement(int num) {
        int t = num;
        t |= t >> 1;
        t |= t >> 2;
        t |= t >> 4;
        t |= t >> 8;
        t |= t >> 16;
        return ~num & t;
    }
}