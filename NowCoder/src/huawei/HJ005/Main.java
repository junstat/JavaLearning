package huawei.HJ005;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in;
        if (!"Linux".equals(System.getProperty("os.name"))) {
            in = new Scanner(Paths.get("/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ005/input.txt"));
        } else {
            in = new Scanner(System.in);
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            solve2(s);
        }
    }

    private static void solve2(String s) {
        int result = 0;
        for (int i = 2; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                result = 16 * result + c - '0';
            } else if ('A' <= c && c <= 'F') {
                result = 16 * result + 10 + (c - 'A');
            }
        }
        System.out.println(result);
    }

    private static void solve1(String s) {
        System.out.println(Integer.parseInt(s.substring(2, s.length()), 16));
    }
}
