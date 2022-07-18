package Q0499.Q0401BinaryWatch.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // 打表逻辑，也可以放到本地做
    // 注意使用 static 修饰，确保打表数据只会被生成一次
    static Map<Integer, List<String>> map = new HashMap<>();

    static {
        for (int h = 0; h <= 11; h++) {
            for (int m = 0; m <= 59; m++) {
                int tot = getCnt(h) + getCnt(m);
                List<String> list = map.getOrDefault(tot, new ArrayList<String>());
                list.add(h + ":" + (m <= 9 ? "0" + m : m));
                map.put(tot, list);
            }
        }
    }

    static int getCnt(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ans++;
        return ans;
    }

    static int lowbit(int x) {
        return x & -x;
    }

    public List<String> readBinaryWatch(int t) {
        return map.getOrDefault(t, new ArrayList<>());
    }
}