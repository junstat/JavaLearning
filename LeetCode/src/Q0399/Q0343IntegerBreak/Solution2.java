package Q0399.Q0343IntegerBreak;

public class Solution2 {
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        int quotient = n / 3, remainder = n % 3;
        if (remainder == 0) return (int) Math.pow(3, quotient);
        else if (remainder == 1) return (int) Math.pow(3, quotient - 1) * 4;
        else return (int) Math.pow(3, quotient) * 2;
    }
}
