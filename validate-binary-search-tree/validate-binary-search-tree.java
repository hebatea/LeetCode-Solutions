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
    Integer prev = null;
    boolean result = true;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return result;
    }

    public boolean inorder(TreeNode root){
        if(root == null) return true;
        boolean left = inorder(root.left);
        
        if(prev != null && prev >= root.val){
            result = false;
        }
        prev = root.val;
        boolean right = inorder(root.right);
        return left && right;
    }

}

/*
     3
  1       4
    2
       
min, max
 
 */