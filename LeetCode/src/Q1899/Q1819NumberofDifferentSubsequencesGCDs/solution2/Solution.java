package Q1899.Q1819NumberofDifferentSubsequencesGCDs.solution2;

public class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int ans = 0, mx = 0;
        for (int x : nums) mx = Math.max(mx, x);
        var has = new boolean[mx + 1];
        for (int x : nums)
            if (!has[x]) {
                has[x] = true;
                ++ans; // 单独一个数也算
            }
        for (int i = 1; i <= mx / 3; ++i) { // 优化循环上界
            if (has[i]) continue;
            int g = 0; // 0 和任何数 x 的最大公约数都是 x
            for (int j = i * 2; j <= mx && g != i; j += i) // 枚举 i 的倍数 j
                if (has[j]) // 如果 j 在 nums 中
                    g = gcd(g, j); // 更新最大公约数
            if (g == i) ++ans; // 找到一个答案
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
