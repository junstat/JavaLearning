package Q0699.Q0621TaskScheduler.solution;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        int max = 0, maxCount = 0;
        for (char task : tasks) {
            int u = task - 'A';
            cnt[u]++;
            if (max == cnt[u]) maxCount++;
            else if (max < cnt[u]) {
                max = cnt[u];
                maxCount = 1;
            }
        }

        int partCount = max - 1, partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        return tasks.length + idles;
    }
}