package Q0099.Q0091.solution1;

import java.util.HashMap;

/*
   Solution 1: Recursion with memoization
   W("") = 1
   W(s) = 0, if s[0] == '0'

   W(s[0....n-1]) = W(s[1....n-1]) + W(s[2...n-1]) if '10' <= s[0]s[1] <= '26'
 */
public class Solution {

    private HashMap<Integer, Integer> m_ways = new HashMap<>();

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        return ways(s, 0, s.length() - 1);
    }

    private int ways(String s, int l, int r) {
        if (m_ways.containsKey(l)) return m_ways.get(l);
        if (l <= r && s.charAt(l) == '0') return 0;
        if (l >= r) return 1;

        int w = ways(s, l + 1, r);
        int prefix = (s.charAt(l) - '0') * 10 + (s.charAt(l + 1) - '0');
        if (prefix <= 26) w += ways(s, l + 2, r);

        m_ways.put(l, w);
        return w;
    }
}
