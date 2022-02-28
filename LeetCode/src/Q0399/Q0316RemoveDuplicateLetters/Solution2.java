package Q0399.Q0316RemoveDuplicateLetters;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {

    public String removeDuplicateLetters(String s) {
        int[] counter = new int[126];       // will contain number of occurrences of character(i+'a')
        boolean[] visited = new boolean[26]; // will contain if character (i+'a') is present in current result stack
        char[] ch = s.toCharArray();
        for (char c : ch) counter[c - 'a']++;  // count number of occurrences of character
        Deque<Character> stack = new ArrayDeque<>();
        int index;

        for (char c : ch) {
            index = c - 'a';
            counter[index]--;   // decrement number of characters remaining in the string to be analysed
            // if character is already present ins stack, don't bother
            if (visited[index]) continue;

            // if current character is smaller than last character in stack which occurs later in the string again
            // it can be removed and added later e.g  stack = bc remaining string abc then a can pop b and then c
            while (!stack.isEmpty() && c < stack.peek() && counter[stack.peek() - 'a'] != 0) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
