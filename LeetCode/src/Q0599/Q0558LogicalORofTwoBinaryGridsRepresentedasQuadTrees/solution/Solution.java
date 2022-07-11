package Q0599.Q0558LogicalORofTwoBinaryGridsRepresentedasQuadTrees.solution;


import Q0599.Q0558LogicalORofTwoBinaryGridsRepresentedasQuadTrees.Node;

public class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) return quadTree1.val ? quadTree1 : quadTree2;
        if (quadTree2.isLeaf) return quadTree2.val ? quadTree2 : quadTree1;
        Node tl = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node tr = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bl = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node br = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        boolean val = tl.val;
        if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf &&
                val == tr.val && val == bl.val && val == br.val) {
            return new Node(val, true, null, null, null, null);
        }
        return new Node(false, false, tl, tr, bl, br);
    }
}
