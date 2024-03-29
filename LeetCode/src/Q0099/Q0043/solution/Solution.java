package Q0099.Q0043.solution;

public class Solution {
    public String multiply(String n1, String n2) {
        int n = n1.length(), m = n2.length();
        int[] res = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int a = n1.charAt(i) - '0';
                int b = n2.charAt(j) - '0';
                int r = a * b;
                r += res[i + j + 1];
                res[i + j + 1] = r % 10;
                res[i + j] += r / 10;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n + m; i++) {
            if (ans.length() == 0 && res[i] == 0) continue;
            ans.append(res[i]);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}