package Q0799.Q0765CouplesHoldingHands.solution2;

public class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int ans = 0;
        int[] cache = new int[n];
        for (int i = 0; i < n; i++) cache[row[i]] = i;
        for (int i = 0; i < n - 1; i += 2) {
            int a = row[i], b = a ^ 1;
            if (row[i + 1] != b) {
                int src = i + 1, tar = cache[b];
                cache[row[tar]] = src;
                cache[row[src]] = tar;
                swap(row, src, tar);
                ans++;
            }
        }
        return ans;
    }

    void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}