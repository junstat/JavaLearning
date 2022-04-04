package huawei.HJ020;

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
        while (in.hasNext()) {
            String s = in.nextLine();
            System.out.println(solve(s));
        }
    }

    private static String solve(String s) {
        // 1.长度超过8位
        if (s.length() <= 8)
            return "NG";
        // 2.包括大小写字母.数字.其它符号,以上四种至少三种
        boolean[] valid = new boolean[4];   // 大写字母、小写字母、数字、其他字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c))
                valid[0] = true;
            else if (Character.isLowerCase(c))
                valid[1] = true;
            else if (Character.isDigit(c))
                valid[2] = true;
            else if (!Character.isSpaceChar(c))
                valid[3] = true;
        }
        int cnt = 0;
        for (boolean elem : valid) {
            if (elem) cnt++;
        }
        if (cnt < 3)
            return "NG";
        // 3.不能有长度大于2的不含公共元素的子串重复 （注：其他符号不含空格或换行）
        for (int start = 3; start < s.length(); start++) {
            if (s.substring(start).contains(s.substring(start - 3, start)))
                return "NG";
        }
        return "OK";
    }
}
