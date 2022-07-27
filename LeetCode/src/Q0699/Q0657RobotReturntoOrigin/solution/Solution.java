package Q0699.Q0657RobotReturntoOrigin.solution;

public class Solution {
    public boolean judgeCircle(String moves) {
        char[] cs = moves.toCharArray();
        int x = 0, y = 0;
        for (char c : cs) {
            switch (c) {
                case 'U': ++y; break;
                case 'D': --y; break;
                case 'L': --x; break;
                case 'R': ++x; break;
            }
        }
        return x == 0 && y == 0;
    }
}
