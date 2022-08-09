package Q0799.Q0784LetterCasePermutation.solution2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<String> letterCasePermutation(String s) {
        int n = s.length();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) continue;
            int cnt = q.size();
            for (int j = 0; j < cnt; j++) {
                String cur = q.poll();
                char[] cs = cur.toCharArray();

                cs[i] = Character.toUpperCase(cs[i]);
                q.add(String.valueOf(cs));
                cs[i] = Character.toLowerCase(cs[i]);
                q.add(String.valueOf(cs));
            }
        }
        return new ArrayList<>(q);
    }
}