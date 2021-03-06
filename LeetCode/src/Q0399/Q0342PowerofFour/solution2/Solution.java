package Q0399.Q0342PowerofFour.solution2;

/*
    it's easy to find that power of 4 numbers have those 3 common features.First,greater than 0.Second,only have one
    '1' bit in their binary notation,so we use x&(x-1) to delete the lowest '1',and if then it becomes 0,it prove
    that there is only one '1' bit.Third,the only '1' bit should be locate at the odd location,for example,16.It's
    binary is 00010000.So we can use '0x55555555' to check if the '1' bit is in the right place.With this thought we
    can code it out easily!
 */
public class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
        // 0x55555555 is to get rid of those power of 2 but not power of 4
        // so that the single 1 bit always appears at the odd position
    }
}
