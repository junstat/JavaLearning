package huawei.HJ009;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    static Scanner in;

    static {
        String inputPath = "/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ009/input.txt";
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
            String s = in.nextLine();
            solve(s);
        }
    }

    static void solve(String s) {
        int[] seen = new int[10];
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (seen[c - '0'] == 1)
                continue;
            seen[c - '0'] = 1;
            System.out.print(c);
        }
    }
}