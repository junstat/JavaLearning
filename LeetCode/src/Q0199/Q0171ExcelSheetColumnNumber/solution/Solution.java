package Q0199.Q0171ExcelSheetColumnNumber.solution;

public class Solution {
    public int titleToNumber(String s) {
        char[] cs = s.toCharArray();
        int ans = 0;
        for (char c : cs) {
            ans = ans * 26 + (c - 'A' + 1);
        }
        return ans;
    }
}