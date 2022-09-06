package Q0799.Q0796RotateString.solution;

public class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}