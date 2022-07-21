package Q0599.Q0500KeyboardRow.solution1;

import java.util.stream.Stream;

// via Regex and Stream
public class Solution {
    public String[] findWords(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }
}