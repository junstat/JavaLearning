package huawei.HJ004;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in;
        if (!"Linux".equals(System.getProperty("os.name"))) {
            in = new Scanner(Paths.get("/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ004/input.txt.txt"));
        } else {
            in = new Scanner(System.in);
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            solve(s);
        }
    }

    private static void solve(String s) {
        int n = s.length();
        for (int start = 0; start < n; start += 8) {
            String segment = s.substring(start, Math.min(start + 8, n));
            System.out.print(segment);
            int rowLen = segment.length();
            while (rowLen < 8) {
                System.out.print("0");
                rowLen++;
            }
            System.out.println();
        }
    }
}
