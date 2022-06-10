package Q0399.Q0397IntegerReplacement;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    Map<Long, Integer> map = new HashMap<>();

    public int integerReplacement(int n) {
        return dfs(n * 1L);
    }

    int dfs(long n) {
        if (n == 1) return 0;
        if (map.containsKey(n)) return map.get(n);
        int ans = n % 2 == 0 ? dfs(n / 2) : Math.min(dfs(n + 1), dfs(n - 1));
        map.put(n, ++ans);
        return ans;
    }
}