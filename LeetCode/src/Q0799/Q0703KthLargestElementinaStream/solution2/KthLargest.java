package Q0799.Q0703KthLargestElementinaStream.solution2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthLargest {
    int k;
    List<Integer> list = new ArrayList<>(10009);

    public KthLargest(int _k, int[] _nums) {
        k = _k;
        for (int i : _nums) list.add(i);
    }

    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        return list.get(list.size() - k);
    }
}