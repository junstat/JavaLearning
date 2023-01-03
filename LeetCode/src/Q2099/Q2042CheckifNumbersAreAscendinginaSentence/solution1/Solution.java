package Q2099.Q2042CheckifNumbersAreAscendinginaSentence.solution1;

public class Solution {
    public boolean areNumbersAscending(String s) {
        int pre = -1, cur = 0, i = -1, n = s.length();
        char[] arr = s.toCharArray();
        while (++i < n) {
            if (Character.isDigit(arr[i])) {
                cur = arr[i] - '0';
                while (i + 1 < n && Character.isDigit(arr[i + 1])) cur = cur * 10 + arr[++i] - '0';
                if (cur <= pre) return false;
                pre = cur;
            }
        }
        return true;
    }
}