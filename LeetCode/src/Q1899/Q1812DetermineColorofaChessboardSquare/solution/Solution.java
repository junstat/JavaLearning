package Q1899.Q1812DetermineColorofaChessboardSquare.solution;

public class Solution {
    public boolean squareIsWhite(String coordinates) {
        char[] cs = coordinates.toCharArray();
        int x = cs[0] - 'a';
        int y = cs[1] - '1';
        return ((x + y) & 1) == 1;
    }
}
