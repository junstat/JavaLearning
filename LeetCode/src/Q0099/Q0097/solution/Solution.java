package Q0099.Q0097.solution;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;

        boolean[][] table = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length() + 1; i++)
            for (int j = 0; j < s2.length() + 1; j++) {
                if (i == 0 && j == 0)
                    table[i][j] = true;
                else if (i == 0)
                    table[i][j] = (table[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                else if (j == 0)
                    table[i][j] = (table[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                else
                    table[i][j] = (table[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                            (table[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }

        return table[s1.length()][s2.length()];
    }
}
