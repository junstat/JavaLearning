package Q0099.Q0020ValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public boolean isValid(String s) {
        Deque<Character> brackets = new ArrayDeque<>();
        Map<Character, Character> bracketMaps = new HashMap<>();
        bracketMaps.put(')', '(');
        bracketMaps.put(']', '[');
        bracketMaps.put('}', '{');
        for (char c : s.toCharArray()) {
            if (bracketMaps.containsValue(c)) brackets.push(c);  // 左括号 => 进栈
            else if (brackets.isEmpty() || bracketMaps.get(c) != brackets.pop()) return false;
        }
        return brackets.isEmpty();
    }
}
