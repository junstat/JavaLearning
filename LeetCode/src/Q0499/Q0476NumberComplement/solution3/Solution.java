package Q0499.Q0476NumberComplement.solution3;

public class Solution {
    public int findComplement(int num) {
        int x = 0;
        for (int i = num; i != 0; i -= i & -i) x = i;
        return ~num & (x - 1);
    }
}