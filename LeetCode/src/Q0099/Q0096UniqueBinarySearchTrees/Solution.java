package Q0099.Q0096UniqueBinarySearchTrees;

/*
  定义两个函数
  G(n): 长度为n的序列能构成的不同二叉搜索树的个数。
  F(i, n): 以i为根、序列长度为n的不同二叉搜索树个数(1 <= i <= n)
  G(n) = sum{F(i, n)} i in [1, n]
  对于边界情况，当序列长度为1(只有根)或为0(空树): G(0) = 1, G(1) = 1

  左子树个数 G(i - 1)，右子树个数G(n - i) ==> F(i, n) = G(i - 1) * G(n - i)
  综上:
  G(n) = sum{G(i - 1) * G(n - i)} i in [1, n]

  时间复杂度: O(n^2) 空间复杂度: O(n)
*/
public class Solution {

    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
