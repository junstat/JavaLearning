package Q0499.Q0457CircularArrayLoop.solution3;

public class Solution {
    int OFFSET = 100010;

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= OFFSET) continue;
            int cur = i, tag = OFFSET + i, last = -1;
            boolean flag = nums[cur] > 0;
            while (true) {
                int next = ((cur + nums[cur]) % n + n) % n;
                last = nums[cur];
                nums[cur] = tag;
                cur = next;
                if (cur == i) break;
                if (nums[cur] >= OFFSET) break;
                if (flag && nums[cur] < 0) break;
                if (!flag && nums[cur] > 0) break;
            }
            if (last % n != 0 && nums[cur] == tag) return true;
        }
        return false;
    }
}