package Q1899.Q1819NumberofDifferentSubsequencesGCDs.solution1;

import java.util.Arrays;

public class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int ans = 0, mx = Arrays.stream(nums).max().getAsInt();
        var has = new boolean[mx + 1];
        for (int x : nums) has[x] = true;
        for (int i = 1; i <= mx; ++i) {
            int g = 0; // 0 和任何数 x 的最大公约数都是 x
            for (int j = i; j <= mx && g != i; j += i) // 枚举 i 的倍数 j
                if (has[j]) // 如果 j 在 nums 中
                    g = gcd(g, j); // 更新最大公约数
            if (g == i) ++ans; // 找到一个答案
        }
        return ans;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
