package Q0099.Q0060PermutationSequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        List<Integer> nums = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            nums.add(i);
        }

        for (int i = 0, l = k - 1; i < n; i++) {
            fact /= (n - i);
            int index = (l / fact);
            result.append(nums.remove(index));
            l -= index * fact;
        }
        return result.toString();
    }
}
