package huawei.HJ003;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in;
        if (!"Linux".equals(System.getProperty("os.name"))) {
            in = new Scanner(Paths.get("/Users/jun/Documents/Learn/JavaLearning/NowCoder/src/huawei/HJ003/input.txt.txt"));
        } else {
            in = new Scanner(System.in);
        }
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = in.nextInt();
            solve(nums);
        }
    }

    private static void solve(int[] nums) {
        Arrays.sort(nums);
        System.out.println(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                System.out.println(nums[i]);
        }
    }
}