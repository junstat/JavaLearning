package Q0699.Q0670MaximumSwap.solution2;

public class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        int[] last = new int[10];
        for (int i = 0; i < n; i++) last[digits[i] - '0'] = i;
        for (int i = 0; i < n; i++) {
            for (int j = 9; j > digits[i] - '0'; --j) {
                if (last[j] > i) {
                    swap(digits, i, last[j]);
                    return Integer.parseInt(new String(digits));
                }
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
