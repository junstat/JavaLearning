package Q0199.Q0131PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/*
    Backtracking
 */
public class Solution1 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> curRet = new ArrayList<>();
        dfs(s, 0, result, curRet);
        return result;
    }

    private void dfs(String s, int pos, List<List<String>> result, List<String> curRet) {
        if (pos == s.length()) {
            result.add(new ArrayList<>(curRet));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (isPalindrome(s, pos, i)) {
                curRet.add(s.substring(pos, i + 1));
                dfs(s, i + 1, result, curRet);
                curRet.remove(curRet.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi)
            if (s.charAt(lo++) != s.charAt(hi--))
                return false;
        return true;
    }
}