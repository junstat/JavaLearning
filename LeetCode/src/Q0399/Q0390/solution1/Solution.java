package Q0399.Q0390.solution1;

public class Solution {
    public int lastRemaining(int n) {
        boolean left = true;
        int head = 1, step = 1, rest = n;
        while (rest > 1) {
            if (left || rest % 2 == 1) head += step;
            rest /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }
}