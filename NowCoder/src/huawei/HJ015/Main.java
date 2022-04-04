package huawei.HJ015;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    static Scanner in;

    public static void main(String[] args) throws IOException {
        if (!"Linux".equals(System.getProperty("os.name"))) {
            in = new Scanner(Paths.get("/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ015/input.txt"));
        } else {
            in = new Scanner(System.in);
        }
        while (in.hasNext()) {
            int n = in.nextInt();
            solve(n);
        }
    }

    private static void solve(int n) {
        System.out.println(Integer.bitCount(n));
    }
}