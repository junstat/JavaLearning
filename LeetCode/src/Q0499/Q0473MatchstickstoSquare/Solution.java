package Q0499.Q0473MatchstickstoSquare;

import java.util.Arrays;

public class Solution {
    public boolean makesquare(int[] matchsticks) {

        if (matchsticks == null || matchsticks.length == 0) return false;
        int sum = 0;
        for (int num : matchsticks) sum += num;
        //if perimeter is not divisible by 4, 也就意味着每个边的长度不同，也就无法排列
        if (sum % 4 != 0) return false;
        //排序
        Arrays.sort(matchsticks);
        //然后从后往前走， 因为从长的火柴开始可以更快的到负数，从而加快循环速度
        return dfs(matchsticks, matchsticks.length - 1, new int[4], sum / 4);
    }

    public boolean dfs(int[] matchsticks, int currIndex, int[] size, int sideLength) {
        //如果四条边都相等，说明满足要求， 返回true
        if (currIndex == -1)
            return size[0] == sideLength && size[1] == sideLength && size[2] == sideLength && size[3] == sideLength;

        for (int i = 0; i < 4; i++) {
            //如果加进去超了直接跳入下一次循环
            if (size[i] + matchsticks[currIndex] > sideLength || (i > 0 && size[i] == size[i - 1])) continue;

            size[i] += matchsticks[currIndex];
            if (dfs(matchsticks, currIndex - 1, size, sideLength)) return true;
            size[i] -= matchsticks[currIndex];
        }
        return false;
    }
}