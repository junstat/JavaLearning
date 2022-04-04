package huawei.HJ007;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    static Scanner in;

    public static void main(String[] args) throws IOException {
        if (!"Linux".equals(System.getProperty("os.name"))) {
            in = new Scanner(Paths.get("/Users/jun/Learn/JavaLearning/NowCoder/src/huawei/HJ007/input.txt"));
        } else {
            in = new Scanner(System.in);
        }
        while (in.hasNext()) {
            solve2();
        }
    }

    private static void solve2() {
        String num = in.nextLine();
        int afterPointNumIndex = num.indexOf('.') + 1;
        if (num.charAt(afterPointNumIndex) >= '5')
            System.out.println(Integer.parseInt(num.substring(0, afterPointNumIndex - 1)) + 1);
        else
            System.out.println(num.substring(0, afterPointNumIndex - 1));
    }

    private static void solve1() {
        float n = in.nextFloat();
        System.out.println(Math.round(n));
    }
}