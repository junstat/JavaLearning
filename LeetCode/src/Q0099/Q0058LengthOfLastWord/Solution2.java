package Q0099.Q0058LengthOfLastWord;

/*
    Well, the basic idea is very simple. Start from the tail of s and move backwards to find the first non-space
    character. Then from this character, move backwards and count the number of non-space characters until we
    pass over the head of s or meet a space character. The count will then be the length of the last word.
 */
public class Solution2 {
    public int lengthOfLastWord(String s) {
        int len = 0, tail = s.length() - 1;
        while (tail >= 0 && s.charAt(tail) == ' ') tail--;  // find the first non-space character.
        while (tail >= 0 && s.charAt(tail) != ' ') {  // find the first space character or until head
            len++;
            tail--;
        }
        return len;
    }
}
