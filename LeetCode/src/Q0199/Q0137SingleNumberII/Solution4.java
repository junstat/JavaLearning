package Q0199.Q0137SingleNumberII;

public class Solution4 {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int x : nums) {
            one = one ^ x & ~two;
            two = two ^ x & ~one;
        }
        return one;
    }
}
