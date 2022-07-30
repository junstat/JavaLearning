package Q0799.Q0729MyCalendarI.solution1;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {
    List<int[]> list = new ArrayList<>();

    public boolean book(int start, int end) {
        end--;
        for (int[] info : list) {
            int l = info[0], r = info[1];
            if (start > r || end < l) continue;
            return false;
        }
        list.add(new int[]{start, end});
        return true;
    }
}