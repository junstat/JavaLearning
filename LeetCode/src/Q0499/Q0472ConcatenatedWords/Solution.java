package Q0499.Q0472ConcatenatedWords;

import java.util.*;

/*
    If you do know one optimized solution for above question is using DP, this problem is just one more step further.
     We iterate through each word and see if it can be formed by using other words.

    Of course it is also obvious that a word can only be formed by words shorter than it. So we can first sort the
    input by length of each word, and only try to form one word by using words in front of it.
 */
public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (w1, w2) -> (w1.length() - w2.length()));
        List<String> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        for (String w : words) {
            boolean[] dp = new boolean[w.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= w.length(); i++) {
                for (int j = i; j > -1; j--) {
                    if (dp[j] && dict.contains(w.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            if (w.length() > 0 && dp[w.length()]) ans.add(w);
            dict.add(w);
        }
        return ans;
    }
}
