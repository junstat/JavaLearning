package Q0399.Q0385MiniParser;


import java.util.ArrayDeque;
import java.util.Deque;


/*
    This approach will just iterate through every char in the string (no recursion).
      If encounters '[', push current NestedInteger to stack and start a new one.
      If encounters ']', end current NestedInteger and pop a NestedInteger from stack to continue.
      If encounters ',', append a new number to curr NestedInteger, if this comma is not right after a brackets.
      Update index l and r, where l shall point to the start of a integer substring, while r shall points to the end+1
      of substring.
 */
public class Solution {

    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) {
            return new NestedInteger(Integer.parseInt(s));
        }
        Deque<NestedInteger> stack = new ArrayDeque<>();
        NestedInteger res = new NestedInteger();
        stack.push(res);
        int start = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                NestedInteger ni = new NestedInteger();
                stack.peek().add(ni);
                stack.push(ni);
                start = i + 1;
            } else if (c == ',' || c == ']') {
                if (i > start) {
                    int val = Integer.parseInt(s.substring(start, i));
                    stack.peek().add(new NestedInteger(val));
                }
                start = i + 1;
                if (c == ']') {
                    stack.pop();
                }
            }
        }
        return res;
    }
}