package algorithm.Q0099.Q0001;

import org.junit.Test;

public class Solution {

    @Test
    public void test1() {
        System.out.println(solve("1", "99"));
    }

    public String solve(String s, String t) {
        StringBuilder result = new StringBuilder();
        int sum = 0, m = s.length(), n = t.length();
        for (int i = 0; i < m || i < n; i++) {
            int n1 = i < m ? s.charAt(m - 1 - i) - '0' : 0;
            int n2 = i < n ? t.charAt(n - 1 - i) - '0' : 0;
            sum += (n1 + n2);
            result.insert(0, sum % 10);
            sum /= 10;
        }
        if (sum != 0) result.insert(0, sum);
        return result.toString();
    }
}
