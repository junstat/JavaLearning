package Q0599.Q0500KeyboardRow;

import java.util.stream.Stream;

// via Regex and Stream
public class Solution1 {
    public String[] findWords(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }
}