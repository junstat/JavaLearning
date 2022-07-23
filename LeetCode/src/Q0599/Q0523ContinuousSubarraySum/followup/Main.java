package Q0599.Q0523ContinuousSubarraySum.followup;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        long[] s = new long[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + sc.nextLong();
        long ans = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        for (int i = 1; i <= n; i++) {
            long u = s[i] % k;
            if (map.containsKey(u)) ans += map.get(u);
            map.put(u, map.getOrDefault(u, 0) + 1);
        }
        System.out.println(ans);
    }
}