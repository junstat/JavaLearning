package Q1899.Q1832CheckiftheSentenceIsPangram.solution2;

public class Solution {
    final static int FULL_LOW_TWENTY_SIX_BIT = 0x3ffffff;

    public boolean checkIfPangram(String sentence) {
        char[] cs = sentence.toCharArray();
        int ans = 0;
        for (char c : cs) {
            ans |= 1 << (c - 'a');
            if ((ans ^ FULL_LOW_TWENTY_SIX_BIT) == 0) {
                return true;
            }
        }
        return false;
    }
}
