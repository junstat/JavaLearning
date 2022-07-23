package Q0199.Q0168ExcelSheetColumnTitle.solution2;

public class Solution {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + n % 26);
    }
}
