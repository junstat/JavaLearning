package Q08.solution;

import DataStructure.TreeLinkNode;

public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;

        TreeLinkNode pNext = null;
        if (pNode.right != null) { // case 1.
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) pRight = pRight.left;
            pNext = pRight;
        } else if (pNode.next != null) {
            TreeLinkNode pCurrent = pNode;
            TreeLinkNode pParent = pNode.next;  // case 2.
            while (pParent != null && pCurrent == pParent.right) { // case 3.
                pCurrent = pParent;
                pParent = pParent.next;
            }
            pNext = pParent;
        }
        return pNext;
    }
}
