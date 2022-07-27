package Q51.solution;

public class Solution {
    static int MOD = 1000000007;

    public int InversePairs(int[] data) {
        if (data == null || data.length <= 0) return 0;
        int[] copy = new int[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);
        return inversePairs(data, copy, 0, data.length - 1);
    }

    int inversePairs(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int len = (end - start) / 2;

        int left = inversePairs(copy, data, start, start + len);
        int right = inversePairs(copy, data, start + len + 1, end);

        int i = start + len;
        int j = end;
        int idxCopy = end;
        int count = 0;
        while (i >= start && j >= start + len + 1) {
            if (data[i] > data[j]) {
                copy[idxCopy--] = data[i--];
                count += j - start - len;
            } else {
                copy[idxCopy--] = data[j--];
            }
        }
        for (; i >= start; i--) copy[idxCopy--] = data[i];
        for (; j >= start + len + 1; j--) copy[idxCopy--] = data[j];
        return (left % MOD + right % MOD + count % MOD) % MOD;
    }
}