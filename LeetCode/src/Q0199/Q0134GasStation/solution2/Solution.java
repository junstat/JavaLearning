package Q0199.Q0134GasStation.solution2;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int start = 0; start < n; start++) {
            // 直接跳过第一步都不满足的起点
            if (gas[start] < cost[start]) continue;
            // 剩余油量
            int cur = gas[start] - cost[start];
            // 所在位置
            int idx = (start + 1) % n;
            while (idx != start) {
                cur += gas[idx] - cost[idx];
                // 如果剩余油量为负数，说明无法离开当前位置，走到下一位置
                if (cur < 0) break;
                idx = (idx + 1) % n;
            }
            if (idx == start) return start;
        }
        return -1;
    }
}
