package Q0799.Q0768MaxChunksToMakeSortedII.solution2;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, ans = 1;
        int[] mx = new int[n], mn = new int[n];
        mx[0] = arr[0];
        mn[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) mx[i] = Math.max(mx[i - 1], arr[i]);
        for (int i = n - 2; i >= 0; i--) mn[i] = Math.min(mn[i + 1], arr[i]);
        for (int i = 1; i < n; i++) if (mn[i] >= mx[i - 1]) ++ans;
        return ans;
    }
}
