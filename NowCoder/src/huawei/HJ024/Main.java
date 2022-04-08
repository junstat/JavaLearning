package huawei.HJ024;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    static Scanner in;
    static String inputFileName = "/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ020/input.txt.txt";

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

    }
}
