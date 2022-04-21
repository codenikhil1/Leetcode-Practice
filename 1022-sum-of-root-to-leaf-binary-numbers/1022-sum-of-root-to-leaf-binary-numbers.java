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
    public int sumRootToLeaf(TreeNode root) {
        int[] ans = {0};
        sum(root,"" + root.val,ans);
        return ans[0];
    }
    
    private void sum(TreeNode root,String path,int[] ans){        
       if(root.left == null && root.right == null){
           int rootToLeaf = 0;
             ans[0] += Integer.parseInt(path,2);
             return ;  
           
       }
        
        if(root.left != null)
            sum(root.left,path + root.left.val,ans);
        if(root.right != null)
            sum(root.right,path + root.right.val,ans);
        
      
            
    }
}