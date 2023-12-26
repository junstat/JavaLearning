package Q2299.Q2276;

import java.util.TreeMap;

public class CountIntervals {

    TreeMap<Integer, Integer> map = new TreeMap<>();
    int cnt = 0;

    public CountIntervals() {

    }

    public void add(int left, int right) {
        var it = map.floorEntry(left);
        if (it == null || it.getValue() < left)
            it = map.higherEntry(left);
        for (; it != null && it.getKey() <= right; it = map.higherEntry(left)) {
            left = Math.min(left, it.getKey());
            right = Math.max(right, it.getValue());
            cnt -= it.getValue() - it.getKey() + 1;
            map.remove(it.getKey());
        }
        map.put(left, right);
        cnt += right - left + 1;
    }

    public int count() {
        return cnt;
    }
}
