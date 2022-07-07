package Q0299.Q0299BullsandCows.solution;

/*
    The idea is to iterate over the numbers in secret and in guess and count all bulls right away. For cows maintain
    an array that stores count of the number appearances in secret and in guess. Increment cows when either number
    from secret was already seen in guest or vice versa.

    https://leetcode.com/problems/bulls-and-cows/discuss/74621/One-pass-Java-solution
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] nums = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (nums[secret.charAt(i) - '0']++ < 0) cows++;
                if (nums[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }
        // return bulls + "A" + cows + "B";
        return String.format("%dA%dB", bulls, cows);
    }
}