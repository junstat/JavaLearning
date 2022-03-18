package Q0499.Q0441ArrangingCoins;

/*
    Math Approach (using Quadratic Formula):
Another way to use math is to use the quadratic formula:
(K * (K+1))/2 <= N
K * (K+1) <= 2N
K^2 + K <= 2N
K^2 + K - 2N <= 0
The quadratic formula is:
x = (-b +- sqrt(b^2 - 4ac))/2a
We use this equation to solve for K, where:
(1) * K^2 + (1) * K - 2N <= 0
x = K
a = 1
b = 1
c = -2N
so:
K <= (-1 + sqrt(1 + 8N))/2
and:
K <= (-1 - sqrt(1 + 8N))/2
Second solution is impossible, because it will return a negative number, and we can't use a negative number to
 create an area.
Final Solution: K <= (-1 + sqrt(1 + 8N))/2
 */
public class Solution2 {
    public int arrangeCoins(int n) {
        return (int) (-1 + (Math.sqrt(1 + 8 * (long) n))) / 2; // cast "n" to "long" to avoid integer overflow
    }
}
