package Q0099.Q0058LengthOfLastWord;

public class Solution1 {
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
