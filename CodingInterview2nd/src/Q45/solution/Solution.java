package Q45.solution;

import java.util.Arrays;

public class Solution {
    public String PrintMinNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = String.valueOf(nums[i]);
        Arrays.sort(ss, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder ans = new StringBuilder();
        for (String s : ss) ans.append(s);
        return ans.toString();
    }
}
