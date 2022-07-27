package Q31.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean IsPopOrder(int[] pushed, int[] poped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;

        for (int num : pushed) {
            stack.addLast(num);

            // 循环判断出栈序列是否相等。
            while (!stack.isEmpty() && stack.peekLast() == poped[i]) {
                stack.pollLast();
                i++;
            }
        }

        return stack.isEmpty();
    }
}


