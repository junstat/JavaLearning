package Q0699.Q0650_2KeysKeyboard.solution3;

public class Solution {
    static int N = 1010;
    static int[] g = new int[N];

    static {
        for (int k = 2; k < N; k++) {
            int cnt = 0, n = k;
            for (int i = 2; i * i <= n; i++) {
                while (n % i == 0) {
                    cnt += i;
                    n /= i;
                }
            }
            if (n != 1) cnt += n;
            g[k] = cnt;
        }
        // System.out.println(Arrays.toString(g)); // 输出打表结果
    }

    public int minSteps(int n) {
        return g[n];
    }
}