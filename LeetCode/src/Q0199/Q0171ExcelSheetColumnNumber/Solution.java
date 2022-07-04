package Q0199.Q0171ExcelSheetColumnNumber;

public class Solution {
    public int titleToNumber(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans * 26 + (cs[i] - 'A' + 1);
        }
        return ans;
    }
}