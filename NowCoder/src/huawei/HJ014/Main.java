package huawei.HJ014;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static Scanner in;

    public static void main(String[] args) throws IOException {
        if (!"Linux".equals(System.getProperty("os.name"))) {
            in = new Scanner(Paths.get("/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ014/input.txt"));
        } else {
            in = new Scanner(System.in);
        }
        while (in.hasNext()) {
            int n = in.nextInt();
            solve(n);
        }
    }

    private static void solve(int n) {
        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String cur = in.next();
            queue.add(cur);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
