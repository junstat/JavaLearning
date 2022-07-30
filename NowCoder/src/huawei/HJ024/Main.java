package huawei.HJ024;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    static Scanner in;

    static {
        String inputPath = "/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ024/input.txt";
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

    static int[] heights;
    static int n;

    public static void main(String[] args) {
        while (in.hasNext()) {
            n = in.nextInt();
            heights = new int[n];
            for (int i = 0; i < n; i++) heights[i] = in.nextInt();
            solve();
        }
    }

    static void solve() {
        int[] left = new int[n];
        // 左侧递增
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            for (int j = 0; j < n; j++) {
                if (heights[i] > heights[j]) left[i] = Math.max(left[i], left[j] + 1);
            }
        }
        int[] right = new int[n];
        // 右侧递减
        for (int i = n - 1; i >= 0; i--) {
            right[i] = 1;
            for (int j = n - 1; j >= 0; j--) {
                if (heights[i] > heights[j]) right[i] = Math.max(right[i], right[j] + 1);
            }
        }
        int ans = 1;
        for (int i = 0; i < n; i++) ans = Math.max(ans, left[i] + right[i] - 1);
        System.out.println(n - ans);
    }
}
