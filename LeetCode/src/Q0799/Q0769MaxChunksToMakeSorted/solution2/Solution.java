package Q0799.Q0769MaxChunksToMakeSorted.solution2;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, ans = 0, mx = 0;
        for (int i = 0; i < n; i++)
            if ((mx = Math.max(mx, arr[i])) == i) ++ans;
        return ans;
    }
}
