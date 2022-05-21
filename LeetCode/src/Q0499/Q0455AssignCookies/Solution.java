package Q0499.Q0455AssignCookies;

import java.util.Arrays;

// Just assign the cookies starting from the child with less greediness to maximize the number of happy children .
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) i++;
        }
        return i;
    }
}