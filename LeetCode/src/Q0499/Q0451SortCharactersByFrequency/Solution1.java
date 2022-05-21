package Q0499.Q0451SortCharactersByFrequency;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
    The logic is very similar to NO.347 and here we just use a map a count and according to the frequency to put it
    into the right bucket. Then we go through the bucket to get the most frequently character and append that to the
    final stringbuilder.
 */
public class Solution1 {
    public static String frequencySort(String s) {
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) map.put(c, new int[]{1, i});
            else {
                int[] freqAndSeq = map.get(c);
                freqAndSeq[0]++;
                map.put(c, freqAndSeq);
            }
        }

        PriorityQueue<Map.Entry<Character, int[]>> pq = new PriorityQueue<>((a, b) ->
                a.getValue()[0] == b.getValue()[0] ? a.getValue()[1] - b.getValue()[1] : b.getValue()[0] - a.getValue()[0]);

        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, int[]> e = pq.poll();
            for (int i = 0; i < e.getValue()[0]; i++)
                sb.append(e.getKey());
        }
        return sb.toString();
    }
}