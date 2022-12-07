package Q1699.Q1687DeliveringBoxesfromStoragetoPorts.solution;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] p = new int[n + 1];
        int[] w = new int[n + 1];
        int[] neg = new int[n + 1];
        int[] W = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = boxes[i - 1][0];//码头位置
            w[i] = boxes[i - 1][1];//箱子重量
            if (i > 1) {
                neg[i] = neg[i - 1] + (p[i - 1] != p[i] ? 1 : 0);
            }
            W[i] = W[i - 1] + w[i];
        }

        int[] f = new int[n + 1];
        int[] g = new int[n + 1];

        Deque<Integer> opt = new LinkedList<>();
        opt.offer(0); //将g的索引添加进来

        for (int i = 1; i <= n; i++) {
            while (!opt.isEmpty() && (i - opt.peekFirst() > maxBoxes || (W[i] - W[opt.peekFirst()]) > maxWeight)) {
                opt.pollFirst();
            }
            f[i] = g[opt.peekFirst()] + neg[i] + 2; //加入当前元素
            if (i != n) {
                g[i] = f[i] - neg[i + 1];
                while (!opt.isEmpty() && g[i] < g[opt.peekLast()]) {
                    opt.pollLast();
                }
                opt.offer(i);
            }

        }
        return f[n];
    }
}