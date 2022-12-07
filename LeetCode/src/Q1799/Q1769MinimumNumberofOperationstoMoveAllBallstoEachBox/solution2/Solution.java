package Q1799.Q1769MinimumNumberofOperationstoMoveAllBallstoEachBox.solution2;

public class Solution {
    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        char[] bc = boxes.toCharArray();
        int rc = 0, lc = (bc[0] == '1' ? 1 : 0); // rc:右侧'1'的总数  lc:左侧'1'的总数
        for (int i = 1; i < bc.length; i++)
            if (bc[i] == '1') {
                result[0] += i; // 初始化第1个盒子操作数
                rc++; // 右侧'1'的总数加1
            }
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + lc - rc; // 第N个盒子操作数
            if (bc[i] == '1') {
                lc++;
                rc--; // 重新计算lc与rc的值
            }
        }
        return result;
    }
}