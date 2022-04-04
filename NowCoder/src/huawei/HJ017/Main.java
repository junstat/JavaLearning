package huawei.HJ017;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    static Scanner in;

    public static void main(String[] args) throws IOException {
        if (!"Linux".equals(System.getProperty("os.name"))) {
            in = new Scanner(Paths.get("/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ017/input.txt"));
        } else {
            in = new Scanner(System.in);
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            solve(s);
        }
    }

    private static void solve(String s) {
        int x = 0;
        int y = 0;

        for (String word : s.split(";")) {
            if (word.length() == 0 || word.length() > 3)
                continue;
            char direction = word.charAt(0);
            String distance = word.substring(1);
            if ((direction != 'A' && direction != 'S' && direction != 'W' && direction != 'D')
                    || (!isNumber(distance)))
                continue;
            int dis = Integer.parseInt(distance);
            if (direction == 'A')
                x -= dis;
            else if (direction == 'D')
                x += dis;
            else if (direction == 'W')
                y += dis;
            else if (direction == 'S')
                y -= dis;
        }
        System.out.printf("%d,%d", x, y);
    }

    private static boolean isNumber(String s) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(s).matches();
    }
}
