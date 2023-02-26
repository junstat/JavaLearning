package Q2099.Q2007FindOriginalArrayFromDoubledArray.solution;

public class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0];
        }
        int[] res = new int[changed.length / 2];
        int max = 0;
        for (int n : changed) {
            max = Math.max(n, max);
        }
        int[] cnt = new int[max + 1];
        for (int n : changed) {
            cnt[n]++;
        }
        int index = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 0) continue;
            if (i * 2 >= cnt.length || cnt[i * 2] == 0) {
                return new int[0];
            }
            cnt[i * 2] -= cnt[i];
            while (cnt[i] > 0) {
                res[index++] = i;
                cnt[i]--;
            }

        }
        return res;
    }
}