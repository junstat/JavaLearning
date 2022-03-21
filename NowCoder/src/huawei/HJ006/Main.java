package huawei.HJ006;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in;
        if (!"Linux".equals(System.getProperty("os.name"))) {
            in = new Scanner(Paths.get("/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ006/input.txt"));
        } else {
            in = new Scanner(System.in);
        }
        while (in.hasNext()) {
            int n = in.nextInt();
            solve(n);
        }
    }

    private static void solve(int n) {
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                System.out.printf("%d ", i);
                n /= i;
            }
        }
        if (n >= 2)
            System.out.println(n);
    }
}