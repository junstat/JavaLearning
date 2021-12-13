package chap03;

import org.junit.Test;

public class Test02_TwoDimensionArray {
    @Test
    public void test1() {
        // 1. 二维数组的声明和初始化
        // 静态初始化
        int[][] arr1 = new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8}};
        // 动态初始化1
        String[][] arr2 = new String[3][2];
        // 动态初始化2
        String[][] arr3 = new String[3][];
        //也是正确的写法：
        int[] arr4[] = new int[][]{{1, 2, 3}, {4, 5, 9, 10}, {6, 7, 8}};
        int[] arr5[] = {{1, 2, 3}, {4, 5}, {6, 7, 8}};

        // 2. 访问数组元素
        System.out.println(arr1[0][1]);
        System.out.println(arr2[1][1]); // null

        arr3[1] = new String[4];
        System.out.println(arr3[1][0]);

        // 3. 获取数组长度
        System.out.println(arr4.length);
        System.out.println(arr4[0].length);
        System.out.println(arr4[1].length);

        // 4. 遍历二维数组
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }
    }
}
