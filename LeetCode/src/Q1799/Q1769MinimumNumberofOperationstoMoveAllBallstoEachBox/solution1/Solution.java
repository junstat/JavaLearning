package Q1799.Q1769MinimumNumberofOperationstoMoveAllBallstoEachBox.solution1;

public class Solution {
    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '0') continue;
            for (int j = 0; j < result.length; j++)
                result[j] += Math.abs(j - i); // 当发现字符为'1'时，计算每个盒子的操作数。
        }
        return result;
    }
}