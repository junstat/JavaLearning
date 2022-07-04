package Q1299.Q1200MinimumAbsoluteDifference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < min) {
                min = diff;
                ans.clear();
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (diff == min) ans.add(Arrays.asList(arr[i], arr[i + 1]));
        }
        return ans;
    }
}
