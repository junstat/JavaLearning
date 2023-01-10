package Q2299.Q2283CheckifNumberHasEqualDigitCountandDigitValue.solution;

public class Solution {
    public boolean digitCount(String num) {
        int[] cnt = new int[10];
        char[] charNum = num.toCharArray();
        int n = num.length();
        for (char c : charNum) {
            cnt[c & 15]++;
        }
        for (int i = 0; i < n; i++) {
            char c = charNum[i];
            if (cnt[i] != (c & 15)) {
                return false;
            }
        }
        return true;
    }
}
