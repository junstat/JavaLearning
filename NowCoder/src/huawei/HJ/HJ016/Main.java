package huawei.HJ.HJ016;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner in;

    static {
        String inputPath = "/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ016/input.txt";
        if (!"Linux".equals(System.getProperty("os.name"))) {
            try {
                in = new Scanner(Paths.get(inputPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            in = new Scanner(System.in);
        }
    }

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        n /= 10;
        int m = in.nextInt();
        Map<Integer, int[]> prices = new HashMap<>();
        Map<Integer, int[]> values = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int v = in.nextInt();
            v /= 10;
            int p = in.nextInt();
            int q = in.nextInt();
            if (q == 0) {
                if (prices.get(i + 1) == null) {
                    prices.put(i + 1, new int[]{0, 0, 0});
                    values.put(i + 1, new int[]{0, 0, 0});
                }
                prices.get(i + 1)[0] = v;
                values.get(i + 1)[0] = v * p;
            } else {
                if (prices.get(q) == null) {
                    prices.put(q, new int[]{0, 0, 0});
                    values.put(q, new int[]{0, 0, 0});
                }
                if (prices.get(q)[1] != 0) {
                    prices.get(q)[2] = v;
                    values.get(q)[2] = v * p;
                } else {
                    prices.get(q)[1] = v;
                    values.get(q)[1] = v * p;
                }
            }
        }
        int[] dp = new int[n + 1];
        Set<Map.Entry<Integer, int[]>> entries = prices.entrySet();
        for (Map.Entry<Integer, int[]> entry : entries) {
            int i = entry.getKey();
            int[] v = entry.getValue();
            for (int j = n; j >= v[0]; j--) {
                int p1 = v[0];
                int p2 = v[1];
                int p3 = v[2];
                int v1 = values.get(i)[0];
                int v2 = values.get(i)[1];
                int v3 = values.get(i)[2];

                dp[j] = Math.max(dp[j], dp[j - p1] + v1);
                dp[j] = j >= p1 + p2 ? Math.max(dp[j], dp[j - p1 - p2] + v1 + v2) : dp[j];
                dp[j] = j >= p1 + p3 ? Math.max(dp[j], dp[j - p1 - p3] + v1 + v3) : dp[j];
                dp[j] = j >= p1 + p2 + p3 ? Math.max(dp[j], dp[j - p1 - p2 - p3] + v1 + v2 + v3) : dp[j];
            }
        }
        System.out.println(dp[n] * 10);
    }
}
