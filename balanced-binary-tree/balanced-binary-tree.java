/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        findDepth(root);
        return result;
    }

    private int findDepth(TreeNode root){
        if(root == null) return 0;
        int leftRoot = findDepth(root.left);
        int rightRoot = findDepth(root.right);
        if(Math.abs(leftRoot - rightRoot) > 1) result = false;
        return 1 + Math.max(leftRoot, rightRoot);
    }
}
/*
        3
    9      20
         15   7


 */