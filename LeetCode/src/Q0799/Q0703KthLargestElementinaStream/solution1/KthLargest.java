package Q0799.Q0703KthLargestElementinaStream.solution1;

import java.util.ArrayList;
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
        int cur = 0;
        for (int i = 0; i < k; i++) {
            int idx = findMax(cur, list.size() - 1);
            swap(cur++, idx);
        }
        return list.get(cur - 1);
    }

    int findMax(int start, int end) {
        int ans = 0, max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            int t = list.get(i);
            if (t > max) {
                max = t;
                ans = i;
            }
        }
        return ans;
    }

    void swap(int a, int b) {
        int c = list.get(a);
        list.set(a, list.get(b));
        list.set(b, c);
    }
}