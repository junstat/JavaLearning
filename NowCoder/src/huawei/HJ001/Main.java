package huawei.HJ001;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in;
        if (!"Linux".equals(System.getProperty("os.name"))) {
            in = new Scanner(Paths.get("/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ001/input.txt"));
        } else {
            in = new Scanner(System.in);
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            solve2(s);
        }
    }

    public static void solve2(String s) {
        int n = s.length();
        int start = n - 1;
        while (start >=0 && s.charAt(start) != ' ')
            start--;
        System.out.println(n - 1 - start);
    }

    public static void solve1(String s) {
        String[] parts = s.split("\\s+");
        System.out.println(parts[parts.length - 1].length());
    }
}
