package Q0099.Q0096UniqueBinarySearchTrees;

/*
  事实上，方法一推导出的G(n)函数的值在数学上被称为卡塔兰数。便于计算定义如下:
  C(0) = 1, G(n + 1) = 2(2n+1) / (n + 2) * G(n)
  时间复杂度 O(n)，空间复杂度O(1)
*/
public class Solution1 {
    public int numTrees(int n) {
        long C = 1;
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2L * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
