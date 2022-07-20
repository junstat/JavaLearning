package Q0099.Q0058LengthOfLastWord.solution1;

public class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
