package Q0399.Q0397IntegerReplacement;

/*
    Of course, doing bitCount on every iteration is not the best way. It is enough to examine the last two digits to
    figure out whether incrementing or decrementing will give more 1's. Indeed, if a number ends with 01, then
    certainly decrementing is the way to go. Otherwise, if it ends with 11, then certainly incrementing is at least
    as good as decrementing (*011 -> *010 / *100) or even better (if there are three or more 1's). This leads to the
    following solution:
 */
public class Solution2 {
    public int integerReplacement(int n) {
        int c = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || ((n >>> 1) & 1) == 0) {
                --n;
            } else {
                ++n;
            }
            ++c;
        }
        return c;
    }
}