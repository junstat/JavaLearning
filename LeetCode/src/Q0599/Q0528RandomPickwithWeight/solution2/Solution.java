package Q0599.Q0528RandomPickwithWeight.solution2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 桶编号 / 桶内编号 / 总数
    int bid, iid, tot;
    List<int[]> list = new ArrayList<>();

    public Solution(int[] w) {
        int n = w.length;
        double sum = 0, min = 1e9;
        for (int i : w) {
            sum += i;
            min = Math.min(min, i);
        }
        double minv = min / sum;
        int k = 1;
        while (minv * k < 1) k *= 10;
        for (int i = 0; i < n; i++) {
            int cnt = (int) (w[i] / sum * k);
            list.add(new int[]{i, cnt});
            tot += cnt;
        }
    }

    public int pickIndex() {
        if (bid >= list.size()) {
            bid = 0;
            iid = 0;
        }
        int[] info = list.get(bid);
        int id = info[0], cnt = info[1];
        if (iid >= cnt) {
            bid++;
            iid = 0;
            return pickIndex();
        }
        iid++;
        return id;
    }
}