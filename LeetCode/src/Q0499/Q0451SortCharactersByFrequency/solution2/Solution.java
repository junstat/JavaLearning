package Q0499.Q0451SortCharactersByFrequency.solution2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public String frequencySort(String s) {
        int[][] cnts = new int[128][2];
        char[] cs = s.toCharArray();
        for (int i = 0; i < 128; i++) cnts[i][0] = i;
        for (char c : cs) cnts[c][1]++;
        Arrays.sort(cnts, (a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            return a[0] - b[0];
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            char c = (char) cnts[i][0];
            int k = cnts[i][1];
            while (k-- > 0) sb.append(c);
        }
        return sb.toString();
    }
}