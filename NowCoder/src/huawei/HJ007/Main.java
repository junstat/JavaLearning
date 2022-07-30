package huawei.HJ007;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    static Scanner in;

    static {
        String inputPath = "/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ007/input.txt";
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
            solve2();
        }
    }

    static void solve2() {
        String num = in.nextLine();
        int afterPointNumIndex = num.indexOf('.') + 1;
        if (num.charAt(afterPointNumIndex) >= '5')
            System.out.println(Integer.parseInt(num.substring(0, afterPointNumIndex - 1)) + 1);
        else
            System.out.println(num.substring(0, afterPointNumIndex - 1));
    }

    static void solve1() {
        float n = in.nextFloat();
        System.out.println(Math.round(n));
    }
}