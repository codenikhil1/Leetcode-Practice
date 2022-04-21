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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> left = new ArrayList<Integer>();
            leaf(root1,left);
        ArrayList<Integer> right = new ArrayList<Integer>();
            leaf(root2,right);
        
        return left.equals(right);
        
        
    }
    
    private void leaf(TreeNode root , ArrayList<Integer> leaf){
        if(root.left == null && root.right == null){
            leaf.add(root.val);
            return;
        }
        
        if(root.left != null)
            leaf(root.left,leaf);
        if(root.right != null)
            leaf(root.right,leaf);
        
            
    }
}