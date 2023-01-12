package Q0899.Q0833FindAndReplaceinString.solution;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    @Test
    public void test1() {
        String s = "abcde";
        int[] indices = {2, 2};
        String[] sources = {"cdef", "bc"};
        String[] targets = {"f", "fe"};
        System.out.println(findReplaceString(s, indices, sources, targets));
    }

    @Test
    public void test2() {
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "fff"};
        System.out.println(findReplaceString(s, indices, sources, targets));
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);

        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            int eIdx = idx + sources[i].length();
            if (eIdx > n) continue;
            String substring = s.substring(idx, eIdx);
            // if (s.substring(idx, idx + sources[i].length()).equals(sources[i])) {
            if (substring.equals(sources[i])) {
                match[idx] = i;
            }
        }

        if (match.length == 0) {
            return s;
        }

        StringBuilder ans = new StringBuilder();
        for (int idx = 0; idx < n; ) {
            if (match[idx] >= 0) {
                ans.append(targets[match[idx]]);
                idx += sources[match[idx]].length();
            } else {
                ans.append(s.charAt(idx++));
            }
        }
        return ans.toString();
    }
}
