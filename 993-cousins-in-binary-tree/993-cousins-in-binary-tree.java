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
    public boolean isCousins(TreeNode root, int x, int y) {
        parentAndLevel parentandLevel = new parentAndLevel();
        cousins(root,x,y,0,null,parentandLevel);
        return parentandLevel.parentOfX !=  parentandLevel.parentOfY &&
                parentandLevel.levelOfX == parentandLevel.levelOfY;
    }
    
    private void cousins(TreeNode root,int x,int y,int level, TreeNode parent,parentAndLevel parentandLevel){
        if(root == null)
            return;
        if(root.val == x){
            parentandLevel.setlevelX(level);
            parentandLevel.setParentOfX(parent);
        }
         if(root.val == y){
            parentandLevel.setlevelY(level);
            parentandLevel.setParentOfY(parent);
        }
        
        cousins(root.left,x,y,level+1,root,parentandLevel);
        cousins(root.right,x,y,level+1,root,parentandLevel);
        
        
    }
}

 class parentAndLevel{
    TreeNode parentOfX;
    TreeNode parentOfY;
    
    int levelOfX;
    int levelOfY;
   
    void setlevelX(int xlevel){
        this.levelOfX = xlevel;
    }
    void setlevelY(int ylevel){
        this.levelOfY = ylevel;
    }
    void setParentOfX(TreeNode x){
        parentOfX = x;
    }
    
     void setParentOfY(TreeNode y){
        parentOfY = y;
    }
    
}