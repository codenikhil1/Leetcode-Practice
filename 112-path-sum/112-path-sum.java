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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null )
            return false;
        return hasSum(root,0,targetSum);
    }
    
    private boolean hasSum(TreeNode root,int sum,int targetSum){ 
        if(root == null)
            return false;
        sum+=root.val;
        if(root.left == null && root.right == null){
            if(targetSum == sum)
                return true;
            return false;
        }
        
        return hasSum(root.left,sum,targetSum) || hasSum(root.right,sum,targetSum); 
        
        
        
    }
}