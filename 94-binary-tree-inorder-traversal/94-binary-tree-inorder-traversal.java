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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
           return list;
        
        preorder(root,list);
        return list;
    }
    //using recursion
    public List<Integer> preorder(TreeNode root,List<Integer> list){
        if(root.left != null)
            preorder(root.left,list);
        
        list.add(root.val);
        
        if(root.right != null)
            preorder(root.right,list);
        return list;
    
    
    }
}