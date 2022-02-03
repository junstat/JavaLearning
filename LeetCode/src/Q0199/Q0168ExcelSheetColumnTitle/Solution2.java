package Q0199.Q0168ExcelSheetColumnTitle;

public class Solution2 {
    // Recursion
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + n % 26);
    }
}
