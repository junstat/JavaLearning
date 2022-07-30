package huawei.HJ006;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    static Scanner in;

    static {
        String inputPath = "/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ006/input.txt";
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