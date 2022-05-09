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
    public boolean isUnivalTree(TreeNode root) {
        return isSame(root.val,root);
    }
    private boolean isSame(int val,TreeNode root){
        if(root == null)
            return true;
        if(root.val != val)
            return false;
        
        return isSame(val,root.left) && isSame(val,root.right);
    }
}