package Q0099.Q0030SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    We use an Map<String, Integer> counts to record the expected times of each word
    and another Map<String, Integer>seen to record the times we have seen. Then we
    check for every possible position of i. Once we meet an expected word or the times
    of some word is larger than its expected times, we stop the check. If we finish the
    check successfully, push i to the result indexes.
 */
public class Solution2 {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        List<Integer> indexes = new ArrayList<>();
        int n = s.length(), num = words.length, len = words[0].length();

        for (int i = 0; i < n - num * len + 1; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                String word = s.substring(i + j * len, i + (j + 1) * len);
                if (!counts.containsKey(word))
                    break;
                seen.put(word, seen.getOrDefault(word, 0) + 1);
                if (seen.get(word) > counts.getOrDefault(word, 0))
                    break;
                j++;
            }
            if (j == num) indexes.add(i);
        }
        return indexes;
    }
}
