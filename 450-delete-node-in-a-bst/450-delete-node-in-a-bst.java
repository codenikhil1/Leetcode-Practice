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
        if(root == null)
            return null;
        
        if(key < root.val)
            root.left = deleteNode(root.left,key);
        else if(key > root.val)
            root.right = deleteNode(root.right,key);
        else{
            if(root.left == null && root.right == null){
                root = null;
                return null;
            }
            if(root.left == null && root.right != null){
                root = root.right;
                return root;
            }
            if(root.right == null && root.left != null){
                root = root.left;
                return root;
            }
            //find mininum val in right subTree    
            TreeNode subsNode = findMin(root.right);
            //swap that with root
            TreeNode temp  = null;
            temp = root;
            root.val = subsNode.val;
            
            //delete that node from right subTree
            
            root.right = deleteNode(root.right,subsNode.val);
            
        }
        
        return root;
        
    }
    
    private TreeNode findMin(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        
        return root;
    }
}