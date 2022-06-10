package Q0899.Q875KokoEatingBananas;

import java.util.Arrays;

public class Solution {
    static int[] p;
    static int speed;

    public int minEatingSpeed(int[] piles, int h) {
        p = piles;
        int lo = 1, hi = Arrays.stream(piles).max().getAsInt();
        int k = hi;
        while (lo < hi) {
            speed = lo + (hi - lo) / 2;
            long time = getTime();
            if (time <= h) {
                k = speed;
                hi = speed;
            } else lo = speed + 1;
        }
        return k;
    }

    long getTime() {
        long time = 0;
        for (int pile : p) {
            int curTime = (pile + speed - 1) / speed;
            time += curTime;
        }
        return time;
    }
}