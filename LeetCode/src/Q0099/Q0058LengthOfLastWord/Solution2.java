package Q0099.Q0058LengthOfLastWord;

public class Solution2 {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int j = n - 1;
        while (j >= 0 && s.charAt(j) == ' ') j--;
        int i = j;
        while (i >= 0 && s.charAt(i) != ' ') i--;
        return j - i;
    }
}