package Q0399.Q0390EliminationGame;

public class Solution {
    public int lastRemaining(int n) {
        boolean left = true;
        int head = 1, step = 1, remaining = n;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }
}