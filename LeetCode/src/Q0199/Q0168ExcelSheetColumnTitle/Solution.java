package Q0199.Q0168ExcelSheetColumnTitle;

public class Solution {

    // Iteration
    public String convertToTitle(int n) {
        /*
            A -> 1, B -> 2, ... Z -> 26, AA -> 27, AB -> 28
         */
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n -= 1;
            result.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return result.reverse().toString();
    }
}
