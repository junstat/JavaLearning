package huawei.HJ.HJ014;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static Scanner in;

    static {
        String inputPath = "/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ014/input.txt";
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
        while (in.hasNext()) {
            int n = in.nextInt();
            solve(n);
        }
    }

    static void solve(int n) {
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
