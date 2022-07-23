package Q0199.Q0168ExcelSheetColumnTitle.solution1;

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n -= 1;
            result.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return result.reverse().toString();
    }
}
