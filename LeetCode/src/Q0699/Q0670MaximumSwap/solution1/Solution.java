package Q0699.Q0670MaximumSwap.solution1;

public class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int[] memo = new int[digits.length];
        int n = digits.length, maxIndex = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] > digits[maxIndex]) maxIndex = i;
            memo[i] = maxIndex;
        }
        for (int i = 0; i < n; i++) {
            if (memo[i] > i && digits[i] != digits[memo[i]]) {
                swap(digits, i, memo[i]);
                return Integer.parseInt(new String(digits));
            }
        }
        return num;
    }

    void swap(char[] d, int i, int j) {
        char c = d[i];
        d[i] = d[j];
        d[j] = c;
    }
}