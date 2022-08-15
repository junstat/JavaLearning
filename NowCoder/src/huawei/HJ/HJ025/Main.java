package huawei.HJ.HJ025;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    static Scanner in;
    static String inputFileName = "/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ025/input.txt";

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

    static String[] I;
    static TreeSet<Integer> R;

    public static void main(String[] args) {
        int m = in.nextInt();
        I = new String[m];
        for (int i = 0; i < m; i++) I[i] = in.next();
        int n = in.nextInt();
        R = new TreeSet<>();
        for (int i = 0; i < n; i++) R.add(in.nextInt());
        solve();
    }

    static void solve() {
        Map<Integer, List<String>> map = new TreeMap<>();
        for (int i = 0; i < I.length; i++) {
            String a = I[i];
            for (int s : R) {
                if (a.contains(String.valueOf(s))) {
                    map.putIfAbsent(s, new ArrayList<>());
                    List<String> list = map.get(s);
                    list.add(String.valueOf(i));
                    list.add(a);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        int tot = 0;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            int num = entry.getKey();
            List<String> values = entry.getValue();
            if (values.isEmpty()) continue;
            int cnt = values.size() / 2;
            tot += values.size() + 2;
            ans.append(num).append(" ")
                    .append(cnt).append(" ");
            for (String value : values) ans.append(value).append(" ");
        }
        ans.insert(0, tot + " ");
        System.out.println(ans.toString());
    }
}
