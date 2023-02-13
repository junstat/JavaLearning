package Q1199.Q1138AlphabetBoardPath.solution;

public class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder ans = new StringBuilder();
        int x = 0, y = 0;
        for (char c : target.toCharArray()) {
            int nx = (c - 'a') / 5, ny = (c - 'a') % 5;
            // String v = nx < x ? "U".repeat(x - nx) : "D".repeat(nx - x);
            String v = nx < x ? repeat("U", x - nx) : repeat("D", nx - x);
            String h = ny < y ? repeat("L", y - ny) : repeat("R", ny - y);
            ans.append(c != 'z' ? v + h : h + v).append('!');
            x = nx;
            y = ny;
        }
        return ans.toString();
    }

    String repeat(String s, int times) {
        int n = s.length();
        char[] cs = s.toCharArray();
        char[] repeated = new char[n * times];
        for (int i = 0; i < times; i++)
            System.arraycopy(cs, 0, repeated, i * n, n);
        return new String(repeated);
    }
}