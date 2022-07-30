package Q0799.Q0729MyCalendarI.solution2;

import java.util.TreeMap;

public class MyCalendar {
    TreeMap<Integer, Integer> tm = new TreeMap<>();

    public boolean book(int start, int end) {
        Integer prev = tm.floorKey(start), next = tm.ceilingKey(start);
        if ((prev == null || tm.get(prev) <= start) && (next == null || end <= next)) {
            tm.put(start, end);
            return true;
        }
        return false;
    }
}