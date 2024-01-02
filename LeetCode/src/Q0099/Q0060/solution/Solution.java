package Q0099.Q0060.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder ans = new StringBuilder();
        List<Integer> nums = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            nums.add(i);
        }
        for (int i = 0, l = k - 1; i < n; i++) {
            fact /= (n - i);
            int idx = (l / fact);
            ans.append(nums.remove(idx));
            l -= idx * fact;
        }
        return ans.toString();
    }
}