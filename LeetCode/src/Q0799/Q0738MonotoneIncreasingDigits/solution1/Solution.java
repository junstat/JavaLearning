package Q0799.Q0738MonotoneIncreasingDigits.solution1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int monotoneIncreasingDigits(int n) {
        List<Integer> nums = new ArrayList<>();
        while (n > 0) {
            nums.add(n % 10);
            n /= 10;
        }
        int i = nums.size() - 2, ans = 0;
        for (; i >= 0 && nums.get(i) >= nums.get(i + 1); --i) ;
        if (i >= 0) {
            while (i + 2 < nums.size() && nums.get(i + 1) == nums.get(i + 2)) ++i;
            nums.set(i + 1, nums.get(i + 1) - 1);
            while (i >= 0) nums.set(i--, 9);
        }
        while (!nums.isEmpty()) {
            ans = ans * 10 + nums.remove(nums.size() - 1);
        }
        return ans;
    }
}
