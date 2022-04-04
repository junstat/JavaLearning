package huawei.HJ008;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    static Scanner in;

    public static void main(String[] args) throws IOException {
        if (!"Linux".equals(System.getProperty("os.name"))) {
            in = new Scanner(Paths.get("/Users/jun/Learn/JavaLearning/NowCoder/src/huawei/HJ008/input.txt"));
        } else {
            in = new Scanner(System.in);
        }
        while (in.hasNext()) {
            int n = in.nextInt();
            solve(n);
        }
    }

    private static void solve(int n) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int index = in.nextInt();
            int value = in.nextInt();
            map.put(index, map.getOrDefault(index, 0) + value);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}