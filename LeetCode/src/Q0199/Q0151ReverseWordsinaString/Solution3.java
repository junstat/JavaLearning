package Q0199.Q0151ReverseWordsinaString;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3 {
    public String reverseWords(String s) {
        int start = 0, end = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (start <= end && s.charAt(start) == ' ') ++start;
        // 去掉字符串末尾的空白字符
        while (start <= end && s.charAt(end) == ' ') --end;

        Deque<String> deque = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (start <= end) {
            char c = s.charAt(start);
            if (word.length() != 0 && c == ' ') {
                deque.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++start;
        }
        deque.offerFirst(word.toString());

        return String.join(" ", deque);
    }
}
