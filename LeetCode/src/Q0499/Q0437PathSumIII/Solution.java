package Q0499.Q0437PathSumIII;

import DataStructure.TreeNode;

import java.util.HashMap;

/*
    So the idea is similar as Two sum, using HashMap to store ( key : the prefix sum, value : how many ways get to
    this prefix sum) , and whenever reach a node, we check if prefix sum - target exists in hashmap or not, if it
    does, we added up the ways of prefix sum - target into res.
    For instance : in one path we have 1,2,-1,-1,2, then the prefix sum will be: 1, 3, 2, 1, 3, let's say we want to
    find target sum is 2, then we will have{2}, {1,2,-1}, {2,-1,-1,2} and {2}ways.

    I used global variable count, but obviously we can avoid global variable by passing the count from bottom up. The
    time complexity is O(n). This is my first post in discuss, open to any improvement or criticism. :)
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}