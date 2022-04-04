package huawei.HJ021;

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
        String letters1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String letters2 = "bcdefghijklmnopqrstuvwxyza";
        String letters3 = "abcdefghijklmnopqrstuvwxyz";
        String letters4 = "22233344455566677778889999";

        while (in.hasNext()) {
            String line = in.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (Character.isUpperCase(c))
                    System.out.print(letters2.charAt(letters1.indexOf(c)));
                else if (Character.isLowerCase(c))
                    System.out.print(letters4.charAt(letters3.indexOf(c)));
                else
                    System.out.print(c);
            }
        }
    }
}
