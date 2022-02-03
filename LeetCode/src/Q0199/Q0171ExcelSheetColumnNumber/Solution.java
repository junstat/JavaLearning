package Q0199.Q0171ExcelSheetColumnNumber;

public class Solution {

    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int cur = columnTitle.charAt(i) - 'A' + 1;
            result = 26 * result + cur;
        }
        return result;
    }
}
