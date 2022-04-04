package huawei.HJ018;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner in;
    static String inputFileName = "/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ018/input.txt";

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
        Map<String, Integer> result = new LinkedHashMap<String, Integer>() {{
            put("a", 0);
            put("b", 0);
            put("c", 0);
            put("d", 0);
            put("e", 0);
            put("error", 0);
            put("pri", 0);
        }};
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] parts = line.split("~");
            String ip = parts[0];
            String mask = parts[1];
            if (ip.startsWith("0.") || ip.startsWith("127."))
                continue;
            if (!isValidIp(ip) || !isValidMask(mask)) {
                result.put("error", result.get("error") + 1);
                continue;
            }
            String level = ipLevel(ip);
            result.put(level, result.get(level) + 1);
            if (isPriIp(ip))
                result.put("pri", result.get("pri") + 1);
        }
        for (int value : result.values())
            System.out.print(value + " ");

    }

    static boolean isValidIp(String s) {
        if (s.contains("..")) return false;
        for (String x : s.split("\\.")) {
            int xInt = Integer.parseInt(x);
            if (xInt < 0 || xInt > 255)
                return false;
        }
        return true;
    }

    static boolean isValidMask(String s) {
        if (!isValidIp(s))
            return false;
        String sBin = ipStr2Bin(s);
        return sBin.contains("0") && sBin.contains("1") && !sBin.contains("01");
    }

    static String int2bit(int x) {
        String binX = Integer.toBinaryString(x);
        int zeroLen = 8 - binX.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < zeroLen; i++)
            res.append(0);
        res.append(binX);
        return res.toString();
    }

    static String ipStr2Bin(String s) {
        StringBuilder res = new StringBuilder();
        for (String x : s.split("\\.")) {
            int xInt = Integer.parseInt(x);
            res.append(int2bit(xInt));
        }
        return res.toString();
    }

    static String ipLevel(String s) {
        // A类地址1.0.0.0~126.255.255.255;
        // B类地址128.0.0.0~191.255.255.255;
        // C类地址192.0.0.0~223.255.255.255;
        // D类地址224.0.0.0~239.255.255.255；
        // E类地址240.0.0.0~255.255.255.255
        long val = Long.parseLong(ipStr2Bin(s), 2);
        if (ipLevelAux(val, "1.0.0.0", "126.255.255.255"))
            return "a";
        else if (ipLevelAux(val, "128.0.0.0", "191.255.255.255"))
            return "b";
        else if (ipLevelAux(val, "192.0.0.0", "223.255.255.255"))
            return "c";
        else if (ipLevelAux(val, "224.0.0.0", "239.255.255.255"))
            return "d";
        else if (ipLevelAux(val, "240.0.0.0", "255.255.255.255"))
            return "e";
        return "";
    }

    static boolean ipLevelAux(long val, String startStr, String endStr) {
        long Start = Long.parseLong(ipStr2Bin(startStr), 2);
        long End = Long.parseLong(ipStr2Bin(endStr), 2);
        return Start <= val && val <= End;
    }


    /*
   def is_pri_ip(s):
    # 10.0.0.0-10.255.255.255
    # 172.16.0.0-172.31.255.255
    # 192.168.0.0-192.168.255.255
     */
    static boolean isPriIp(String s) {
        long val = Long.parseLong(ipStr2Bin(s), 2);
        return ipLevelAux(val, "10.0.0.0", "10.255.255.255") ||
                ipLevelAux(val, "172.16.0.0", "172.31.255.255") ||
                ipLevelAux(val, "192.168.0.0", "192.168.255.255");
    }
}
