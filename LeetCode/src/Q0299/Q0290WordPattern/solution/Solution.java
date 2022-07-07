package Q0299.Q0290WordPattern.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        Map index = new HashMap();
        for (int i = 0; i < words.length; i++) {
            // if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
            //     return false;
            if (!Objects.equals(index.put(pattern.charAt(i), i),
                    index.put(words[i], i)))
                return false;
        }
        return true;
    }
}
