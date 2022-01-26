package Q0199.Q0151ReverseWordsinaString;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}