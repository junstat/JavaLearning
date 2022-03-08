package Q0399.Q0387FirstUniqueCharacterinaString;

public class Solution2 {
    public int firstUniqChar(String s) {
        int ans = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int left = s.indexOf(c);
            if (left != -1 && left == s.lastIndexOf(c)) {
                ans = Math.min(left, ans);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
