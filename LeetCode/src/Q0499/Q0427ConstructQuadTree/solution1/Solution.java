package Q0499.Q0427ConstructQuadTree.solution1;

import Q0499.Q0427ConstructQuadTree.Node;

public class Solution {
    int[][] g;

    public Node construct(int[][] grid) {
        g = grid;
        return dfs(0, 0, g.length - 1, g.length - 1);
    }

    Node dfs(int a, int b, int c, int d) {
        boolean ok = true;
        int t = g[a][b];
        for (int i = a; i <= c && ok; i++) {
            for (int j = b; j <= d && ok; j++) {
                if (g[i][j] != t) {
                    ok = false;
                    break;
                }
            }
        }

        if (ok) return new Node(t == 1, true);
        Node root = new Node(t == 1, false);
        int dx = c - a + 1, dy = d - b + 1;
        root.topLeft = dfs(a, b, a + dx / 2 - 1, b + dy / 2 - 1);
        root.topRight = dfs(a, b + dy / 2, a + dx / 2 - 1, d);
        root.bottomLeft = dfs(a + dx / 2, b, c, b + dy / 2 - 1);
        root.bottomRight = dfs(a + dx / 2, b + dy / 2, c, d);
        return root;
    }
}