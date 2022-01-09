package Q0099.Q0048RotateImage;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/*
   1> Rotation of point through 90° about the origin in clockwise direction when point M (x, y) is rotated about the
   origin O through 90° in clockwise direction. The new position of point M (x, y) will become M’ (y, -x).
   - - - - - - - - - - - -
   2> 关于对称变换
   (x, y) (关于x轴对称) -> (x, -y)
   (x, y) (关于y=-x 对称) -> (-y, -x)
   - - - - - - - - - - - -
   Summary: 1> 顺时针旋转 90度 等价于  (x, y) -> (y, -x)
            2> (x, y) (关于x轴对称) -> (x, -y) (关于y=-x 对称) -> (y, -x)
 */
public class Solution {

    @Test
    public void test1() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                assertEquals(matrix[i][j], expected[i][j]);
            }
        }
    }

    /*
       clockwise rotate
       first reverse up to down, then swap the symmetry
       1 2 3     7 8 9     7 4 1
       4 5 6 =>  4 5 6 =>  8 5 2
       7 8 9     1 2 3     9 6 3
     */
    public void rotate(int[][] matrix) {
        // 反转二维数组
        Collections.reverse(Arrays.asList(matrix));

        // 对上三角部分，进行按主对角线对称交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; ++j)
                exchange(matrix, i, j, j, i);
        }
    }

    private void exchange(int[][] matrix, int i, int j, int m, int n) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = temp;
    }
}

/*
   拓展:
      anticlockwise rotate
      first reverse left to right, then swap the symmetry
      1 2 3     3 2 1     3 6 9
      4 5 6  => 6 5 4  => 2 5 8
      7 8 9     9 8 7     1 4 7
 */

    /*
    void anti_rotate(vector<vector<int> > &matrix) {
        for (auto vi : matrix) reverse(vi.begin(), vi.end());
        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = i + 1; j < matrix[i].size(); ++j)
                swap(matrix[i][j], matrix[j][i]);
        }
    }
    */