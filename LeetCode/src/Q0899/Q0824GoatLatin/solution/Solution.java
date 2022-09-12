package Q0899.Q0824GoatLatin.solution;

public class Solution {
    public String toGoatLatin(String s) {
        int n = s.length();
        String last = "a";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && s.charAt(j) != ' ') j++;
            if ("aeiouAEIOU".indexOf(s.charAt(i)) >= 0) {
                sb.append(s.substring(i, j)).append("ma");
            } else {
                sb.append(s.substring(i + 1, j)).append(s.charAt(i)).append("ma");
            }
            sb.append(last);
            last += "a";
            i = j + 1;
            if (i < n) sb.append(" ");
        }
        return sb.toString();
    }
}