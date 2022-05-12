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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preIndex[] = {0};
        return constructTree(preorder,inorder,preIndex,0,inorder.length - 1);
    }
    private TreeNode constructTree(int[] preorder,int[] inorder,int[] preIndex,int inStart,int inEnd){
        if(preIndex[0] > preorder.length || inStart > inEnd)
            return null;
        
        int currentVal = preorder[preIndex[0]];
        TreeNode node = new TreeNode(currentVal);
        preIndex[0]++;
        int i = -1;
        for(i = inStart ; i <= inEnd ; i++){
            if(inorder[i] == currentVal)
                break;
        }
        
        node.left = constructTree(preorder,inorder,preIndex,inStart,i-1);
        node.right = constructTree(preorder,inorder,preIndex,i+1,inEnd);
        
        return node;
    }
}