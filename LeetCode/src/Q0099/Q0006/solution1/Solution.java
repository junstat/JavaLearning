package Q0099.Q0006.solution1;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();

        int curRow = 0;
        boolean goDown = true;

        for (int i = 0; i < s.length(); i++) {
            rows[curRow].append(s.charAt(i));
            if (curRow == 0 || curRow == (numRows - 1)) goDown = !goDown;
            curRow += goDown ? -1 : 1;
        }
        for (int i = 1; i < rows.length; i++) rows[0].append(rows[i]);
        return rows[0].toString();
    }
}
