package Q0499.Q0441ArrangingCoins;

/*
    Math Approach (using algebra):
Let's revisit our equation to calculate the area:
(K * (K+1))/2 = N
We know that our answer not only has to be "N", but it can also be less than "N", so we can change our equation to:
(K * (K+1))/2 <= N
If we want to return "K", then what is stopping us from changing to equation so that one side contains "K"?
(K * (K+1))/2 <= N
(K * (K+1)) <= 2N
K^2 + K <= 2N

Complete the square:
K^2 + K + 1/4 - 1/4 <= 2N
(K + 1/2)^2 - 1/4 <= 2N
(K + 1/2)^2 <= 2N + 1/4
K + 1/2 <= sqrt(2N + 1/4)

Our final equation:
K <= sqrt(2N + 1/4) - 1/2
We have to solve this as a double, and then return it as an integer
 */
public class Solution1 {
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5); // cast "n" to "long" to avoid integer overflow
    }
}