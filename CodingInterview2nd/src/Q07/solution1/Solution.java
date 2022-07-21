package Q07.solution1;


import DataStructure.TreeNode;

public class Solution {
    int[] PRE, IN;

    public TreeNode reConstructBinaryTree(int[] _pre, int[] _vin) {
        PRE = _pre;
        IN = _vin;
        if (PRE == null || IN == null || PRE.length == 0 || IN.length == 0) return null;
        return construct(0, 0, IN.length - 1);
    }

    /**
     * @param ps: start of pre order
     * @param is: start of in order
     * @param ie: end of in order
     * @return
     */
    TreeNode construct(int ps, int is, int ie) {
        // ps 即为root
        if (ps > PRE.length - 1 || is > ie) return null;
        TreeNode root = new TreeNode(PRE[ps]);
        int rii = 0;
        for (int i = is; i <= ie; i++) {
            if (IN[i] == root.val) {
                rii = i;
                break;
            }
        }

        root.left = construct(ps + 1, is, rii - 1);
        root.right = construct(ps + rii - is + 1, rii + 1, ie);
        return root;
    }
}