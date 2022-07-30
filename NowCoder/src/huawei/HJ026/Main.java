package huawei.HJ026;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner in;
    static String inputFileName = "/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ026/input.txt";

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

    static String s;

    public static void main(String[] args) {
        while (in.hasNext()) {
            s = in.nextLine();
            solve();
        }
    }

    static void solve() {
        char[] cs = s.toCharArray();
        List<Character> letters = new ArrayList<>();
        for (char c : cs) {
            if (Character.isLetter(c)) letters.add(c);
        }
        letters.sort((a, b) -> Character.toLowerCase(a) - Character.toLowerCase(b));
        int i = 0;
        StringBuilder ans = new StringBuilder();
        for (char c : cs) {
            if (Character.isLetter(c)) ans.append(letters.get(i++));
            else ans.append(c);
        }
        System.out.println(ans.toString());
    }
}
