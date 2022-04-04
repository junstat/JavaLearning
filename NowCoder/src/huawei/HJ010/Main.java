package huawei.HJ010;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    static Scanner in;

    public static void main(String[] args) throws IOException {
        if (!"Linux".equals(System.getProperty("os.name"))) {
            in = new Scanner(Paths.get("/Users/jun/Learn/JavaLearning/NowCoder/src/huawei/HJ010/input.txt"));
        } else {
            in = new Scanner(System.in);
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            solve(s);
        }
    }

    private static void solve(String s) {
        int[] seen = new int[128];
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen[c] == 1)
                continue;
            seen[c] = 1;
        }
        for (int j : seen) result += j;
        System.out.println(result);
    }
}