package huawei.HJ023;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
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
        while (in.hasNext()) {
            String s = in.nextLine();
            solve(s);
        }
    }

    private static void solve(String s) {
        // 统计字符串出现次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 快速找出最少次数
        int min = Integer.MAX_VALUE;
        for (int cnt : map.values()) {
            min = Math.min(min, cnt);
        }
        // 删除出现最少的字符
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) != min)
                res.append(c);
        }
        System.out.println(res.toString());
    }
}
