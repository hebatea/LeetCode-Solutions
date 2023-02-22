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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null && root.right == null){
                root = null;
            }else if (root.left == null){
                root = root.right;
            }else if (root.right == null){
                root = root.left;
            }else{
                TreeNode temp = findMin(root.right);
                root.val = temp.val;
                root.right =  deleteNode(root.right, temp.val);
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode root){
        if(root == null) return root;
        if(root.left == null) return root;
        return findMin(root.left);
    }
}