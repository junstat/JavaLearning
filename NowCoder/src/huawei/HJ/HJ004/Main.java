package huawei.HJ.HJ004;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    static Scanner in;

    static {
        String inputPath = "/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ004/input.txt";
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
