package Q0399.Q0319BulbSwitcher;

/*
    Math Solution:
    如果将所有的灯泡从左到右依次编号为1, 2, ..., n，那么可以发现:
    在第i轮时，会将所有编号为i的倍数的灯泡进行切换。
    因此，对于第k个灯泡，它被切换的次数恰好就是k的约数的个数。如果k有偶数个约数，那么最终第k个灯泡的状态为暗；如果k有奇数个约数，那么最终第k
    个灯泡的状态为亮。
    对于k而言，如果它有约数x，那么一定有约数k/x。因此只要当x^2 != k时，约数都是成对出现的。这就说明，只有当k是完全平方数时，它才会有奇数个
    约数，否则一定有偶数个约数。
    因此只需要找出1, 2,..., n中的完全平方数的个数即可，答案即为 floor(sqrt(n))

    A bulb ends up on iff it is switched an odd number of times.
    Call them bulb 1 to bulb n. Bulb i is switched in round d if and only if d divides i. So bulb i ends up on if and
    only if it has an odd number of divisors.
    Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and 3 and 4. Except when i is a square, like 36
    has divisors 1 and 36, 2 and 18, 3 and 12, 4 and 9, and double divisor 6. So bulb i ends up on if and only if i
    is a square.
 */
public class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5);
    }
}
