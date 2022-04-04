package huawei.HJ019;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    static Scanner in;
    static String inputFileName = "/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ019/input.txt";

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
        Map<String, Integer> result = new LinkedHashMap<>();
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] parts = line.split("\\s+");
            String fullName = parts[0];
            String lineNo = parts[1];
            String[] fullNameParts = fullName.split("\\\\");
            String fullNameLastPart = fullNameParts[fullNameParts.length - 1];
            String fileName = fullNameLastPart.substring(Math.max(fullNameLastPart.length() - 16, 0));
            String resKey = String.format("%s %s", fileName, lineNo);
            result.put(resKey, result.getOrDefault(resKey, 0) + 1);
        }

        int cnt = 0;
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (result.size() - cnt <= 8)
                System.out.println(entry.getKey() + " " + entry.getValue());
            cnt++;
        }
    }
}
