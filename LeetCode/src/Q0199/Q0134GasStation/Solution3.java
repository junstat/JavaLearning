package Q0199.Q0134GasStation;

public class Solution3 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int start = 0; start < n; ) {
            if (gas[start] < cost[start]) start++;
            else {
                int cur = gas[start] - cost[start];
                int idx = start + 1;
                while (idx % n != start) {
                    cur += gas[idx % n] - cost[idx % n];
                    if (cur < 0) break;
                    idx++;
                }
                if (idx % n == start) return start;
                else start = idx;
            }
        }
        return -1;
    }
}
