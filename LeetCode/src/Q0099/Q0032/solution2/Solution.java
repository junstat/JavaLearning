package Q0099.Q0032.solution2;

import java.util.Deque;
import java.util.LinkedList;

/*
    通过栈，可以在遍历给定字符串的过程中去判断到目前为止扫描的子串的有效性，同时能得到最长有效括号的长度。
    具体做法是始终保持栈底元素为当前已经遍历过的元素中“最后一个没有配匹配的右括号的下标”，栈里其他元素维护左括号的下标:
    a.) 对于遇到的每个"("，将它的下标放入栈中；
    b.) 对于遇到的每个")"，先弹出栈顶元素标出匹配了当前右括号
        b.1) 如果栈为空，说明当前的右括号为没有被匹配的右括号，将其下标放入栈中来更新“最后一个没有配匹配的右括号的下标”。
        b.2) 如果栈不空，当前右括号的下标减去栈顶元素即为，以当前右括号为结尾的最长有效括号长度。
    需要注意的是，如果一开始栈为空，第一个字符为左括号的时候，会入栈，这样就不满足上面的栈底元素定
    义，为了保持统一，在一开始的时候往栈中放入一个值为-1的元素。
 */
public class Solution {

    public int longestValidParentheses(String s) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else ans = Math.max(ans, i - stack.peek());
            }
        }
        return ans;
    }
}
