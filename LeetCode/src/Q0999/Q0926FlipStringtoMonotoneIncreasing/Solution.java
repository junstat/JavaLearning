package Q0999.Q0926FlipStringtoMonotoneIncreasing;

public class Solution {
    public int minFlipsMonoIncr(String s) {
        int ones = 0, flips = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') ++ones;
            else ++flips;
            flips = Math.min(ones, flips);
        }
        return flips;
    }
}
