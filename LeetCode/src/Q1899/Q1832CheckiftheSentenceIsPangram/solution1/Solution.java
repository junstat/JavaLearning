package Q1899.Q1832CheckiftheSentenceIsPangram.solution1;

public class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] cnt = new int[26];
        char[] cs = sentence.toCharArray();
        for (char c : cs) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
