package Q1999.Q1971.solution;

public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DisJointSet djs = new DisJointSet(n);
        for (int[] edge : edges) {
            djs.union(edge[0], edge[1]);
        }
        return djs.isConnected(source, destination);
    }
}

class DisJointSet {
    // 节点信息，nodes[i]的值表示第i个结点的根结点(集合元素代表)
    int[] nodes;
    // 使用路径压缩后，可以不适用辅助数组
    int count;

    // 初始化：相当于 MAKE-SET(x)
    public DisJointSet(int x) {
        count = x;
        nodes = new int[count];
        for (int i = 0; i < count; i++) {
            // 初始化时，每个结点都是以自己为单个集合
            nodes[i] = i;
        }
    }

    // UNION(x, y):将两个有关系的集合结点并成一个新集合，相当于说一棵树接到另一棵树
    public void union(int x, int y) {
        // 首先要找到两个结点的根结点(集合代表)
        int xRoot = findSet(x), yRoot = findSet(y);
        // 当根结点都相同时，没有必要继续执行合并
        if (xRoot == yRoot) return;
        // 有路径压缩后，不用深度辅助数组，直接接到根结点上
        nodes[xRoot] = yRoot;
        count--;
    }

    // FIND-SET: 找到结点x所在集合中的代表(相当于找这棵树的根结点)
    public int findSet(int x) {
        // 直接把该集合所有结点接到根结点下面，拍平，此时树深度为2
        if (nodes[x] != x)
            nodes[x] = findSet(nodes[x]);
        return nodes[x];
    }

    public int getCount() {
        return count;
    }

    public boolean isConnected(int x, int y) {
        return findSet(x) == findSet(y);
    }
}