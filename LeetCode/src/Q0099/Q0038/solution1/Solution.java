package Q0099.Q0038.solution1;

public class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 2; i <= n; i++) {
            String cur = "";
            int m = ans.length();
            for (int j = 0; j < m; ) {
                int k = j + 1;
                while (k < m && ans.charAt(j) == ans.charAt(k)) k++;
                int cnt = k - j;
                cur += cnt + "" + ans.charAt(j);
                j = k;
            }
            ans = cur;
        }
        return ans;
    }
}