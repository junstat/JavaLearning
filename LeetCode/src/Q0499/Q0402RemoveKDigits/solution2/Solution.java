package Q0499.Q0402RemoveKDigits.solution2;

// Runtime: 5 ms, faster than 93.06% of Java online submissions for Remove K Digits.
public class Solution {
    public String removeKdigits(String num, int k) {
        char[] numCharArray = num.toCharArray();
        int start = 0;
        int end = 0;
        for (int idx = 0; idx < numCharArray.length; idx++) {
            if (end > 0 && k > 0 && numCharArray[end - 1] > numCharArray[idx]) {
                k--;
                idx--;
                end--;
            } else {
                numCharArray[end++] = numCharArray[idx];
            }
        }
        if (k > 0) {
            end -= k;
        }
        while (end > start && numCharArray[start] == '0') {
            start++;
        }
        return start == end ? "0" : new String(numCharArray, start, end - start);
    }
}
