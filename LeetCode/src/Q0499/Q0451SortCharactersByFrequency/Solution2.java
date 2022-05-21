package Q0499.Q0451SortCharactersByFrequency;

import java.util.PriorityQueue;
import java.util.Queue;

// Runtime: 8 ms, faster than 95.51% of Java online submissions for Sort Characters By Frequency.
public class Solution2 {

    static class Elem {
        char c;
        int cnt;

        public Elem(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static String frequencySort(String s) {
        char[] str = s.toCharArray();
        int[] cnt = new int[256];

        for (char c : str) {
            cnt[c]++;
        }

        Queue<Elem> pq = new PriorityQueue<>((a, b) -> b.cnt - a.cnt);

        for (int i = 0; i < 256; i++) {
            if (cnt[i] > 0) {
                pq.offer(new Elem((char) i, cnt[i]));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Elem e = pq.poll();

            for (int j = 0; j < e.cnt; j++) {
                sb.append(e.c);
            }
        }

        return sb.toString();
    }
}
