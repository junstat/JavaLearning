package Q0099.Q0006ZigZagConversion;

public class Solution1 {
    /*
      1. 使用含min(numRows, len(s)) 个字符串的list表示非空行
      2. 遍历给定字符串，将遍历字符放入合适的行
      3. 使用标志位goUp表示是否向上，仅在第1行和末尾行需要改变行进方向
      4. 遍历结束，把所有行拼接在一起即可
     */
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
