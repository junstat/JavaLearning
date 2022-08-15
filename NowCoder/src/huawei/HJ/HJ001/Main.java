package huawei.HJ.HJ001;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    static Scanner in;

    static {
        String inputPath = "/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ001/input.txt";
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
            solve2(s);
        }
    }

    public static void solve2(String s) {
        int n = s.length();
        int start = n - 1;
        while (start >= 0 && s.charAt(start) != ' ')
            start--;
        System.out.println(n - 1 - start);
    }

    public static void solve1(String s) {
        String[] parts = s.split("\\s+");
        System.out.println(parts[parts.length - 1].length());
    }
}
