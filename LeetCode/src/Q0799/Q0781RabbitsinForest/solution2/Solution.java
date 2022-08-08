package Q0799.Q0781RabbitsinForest.solution2;

public class Solution {
    int N = 1009;
    int[] counts = new int[N];

    public int numRabbits(int[] cs) {
        // counts[x] = cnt 代表在 cs 中数值 x 的数量为 cnt
        for (int i : cs) counts[i]++;
        int ans = counts[0];
        for (int i = 1; i < N; i++) {
            int per = i + 1;
            int cnt = counts[i];
            int k = cnt / per;
            if (k * per < cnt) k++;
            ans += k * per;
        }
        return ans;
    }
}