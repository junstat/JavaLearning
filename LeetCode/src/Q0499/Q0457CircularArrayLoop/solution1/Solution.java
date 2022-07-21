package Q0499.Q0457CircularArrayLoop.solution1;

public class Solution {
    int n;
    int[] nums;

    public boolean circularArrayLoop(int[] _nums) {
        nums = _nums;
        n = nums.length;
        for (int i = 0; i < n; i++) {
            if (check(i)) return true;
        }
        return false;
    }

    boolean check(int start) {
        int cur = start;
        boolean flag = nums[start] > 0;
        int k = 1;
        while (true) {
            if (k > n) return false;
            int next = ((cur + nums[cur]) % n + n) % n;
            if (flag && nums[next] < 0) return false;
            if (!flag && nums[next] > 0) return false;
            if (next == start) return k > 1;
            cur = next;
            k++;
        }
    }
}