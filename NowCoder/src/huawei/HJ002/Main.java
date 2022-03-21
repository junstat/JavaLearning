package huawei.HJ002;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in;
        if (!"Linux".equals(System.getProperty("os.name"))) {
            in = new Scanner(Paths.get("/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ002/input.txt"));
        } else {
            in = new Scanner(System.in);
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            String key = in.nextLine();
            solve(s, key.charAt(0));
        }
    }

    private static void solve(String s, char key) {
        int cnt = 0;
        char keyLowerCase = Character.toLowerCase(key);
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (c == keyLowerCase)
                cnt++;
        }
        System.out.println(cnt);
    }
}
