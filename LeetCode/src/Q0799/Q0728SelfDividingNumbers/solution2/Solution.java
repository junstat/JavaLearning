package Q0799.Q0728SelfDividingNumbers.solution2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static List<Integer> list = new ArrayList<>();

    static {
        out:
        for (int i = 1; i <= 10000; i++) {
            int cur = i;
            while (cur != 0) {
                int u = cur % 10;
                if (u == 0 || i % u != 0) continue out;
                cur /= 10;
            }
            list.add(i);
        }
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (list.get(mid) >= left) r = mid;
            else l = mid + 1;
        }
        while (r < list.size() && list.get(r) <= right) ans.add(list.get(r++));
        return ans;
    }
}