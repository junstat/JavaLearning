package Q0399.Q0365WaterandJugProblem.solution;

class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        //limit brought by the statement that water is finallly in one or both buckets
        if (x + y < z) return false;
        // case x or y is zero
        if (x == z || y == z || x + y == z) return true;
        return z % gcdRecursion(x, y) == 0;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int c = b;
            b = a % b;
            a = c;
        }
        return a;
    }

    int gcdRecursion(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}