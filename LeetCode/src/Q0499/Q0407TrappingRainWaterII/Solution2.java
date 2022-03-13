package Q0499.Q0407TrappingRainWaterII;

// Runtime: 11 ms, faster than 98.70% of Java online submissions for Trapping Rain Water II.
public class Solution2 {
    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length;
        int col = heightMap[0].length;
        int[][] volume = new int[row][col];
        for (int i = 0; i < row; i++) {
            System.arraycopy(heightMap[i], 0, volume[i], 0, col);
        }
        boolean update = true;
        boolean init = true;
        while (update) {
            update = false;
            for (int i = 1; i < row - 1; i++) {
                for (int j = 1; j < col - 1; j++) {
                    int val = Math.max(heightMap[i][j], Math.min(volume[i - 1][j], volume[i][j - 1]));
                    if (init || val < volume[i][j]) {
                        volume[i][j] = val;
                        update = true;
                    }
                }
            }
            init = false;
            for (int i = row - 2; i >= 1; i--) {
                for (int j = col - 2; j >= 1; j--) {
                    int val = Math.max(heightMap[i][j], Math.min(volume[i + 1][j], volume[i][j + 1]));
                    if (val < volume[i][j]) {
                        volume[i][j] = val;
                        update = true;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (volume[i][j] - heightMap[i][j] > 0) {
                    sum += volume[i][j] - heightMap[i][j];
                }
            }
        }
        return sum;
    }
}
