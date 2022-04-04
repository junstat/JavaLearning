package huawei.HJ022;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    static Scanner in;
    static String inputFileName = "/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ020/input.txt";

    static {
        if (!"Linux".equals(System.getProperty("os.name"))) {
            try {
                in = new Scanner(Paths.get(inputFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            in = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n != 0)
                solve(n);
        }
    }

    static void solve(int n) {
        int res = 0;
        while (n > 3) {
            res += n / 3;
            n = n / 3 + n % 3;
        }
        // 1 -> 0, 2 -> 1, 3 -> 1
        if (n != 1)
            res++;
        System.out.println(res);
    }
}
