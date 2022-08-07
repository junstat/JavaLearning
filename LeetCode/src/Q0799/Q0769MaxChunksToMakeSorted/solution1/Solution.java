package Q0799.Q0769MaxChunksToMakeSorted.solution1;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, ans = 0, sum = 0;
        for (int i = 0; i < n; i++)
            if ((sum += arr[i] - i) == 0) ++ans;
        return ans;
    }
}
