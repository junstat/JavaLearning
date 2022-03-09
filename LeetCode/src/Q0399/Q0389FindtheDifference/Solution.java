package Q0399.Q0389FindtheDifference;

/*
    xor 异或的性质:
    交换率 A ^ B = B ^ A
    结合律 A ^ (B ^ C) = (A ^ B)^C
    恒等律 X ^ 0 = X
    归零律 X ^ X = 0
    自反  A ^ B ^ B = A ^ 0 = A
    对于任意的X: X ^ (-1) = ~X
    如果 A ^ B = C成立，那么A^B=C, B^C=A
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        int n = t.length();
        char c = t.charAt(n - 1);
        for (int i = 0; i < n - 1; i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
