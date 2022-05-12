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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] postIndex = {postorder.length - 1};
        HashMap<Integer,Integer> inOrderIndexMap = new HashMap<>();
        buildMap(inOrderIndexMap,inorder);
        return constructTree(postorder,inOrderIndexMap,postIndex,0,inorder.length - 1);
    }
   
    private TreeNode constructTree(int[] postorder,HashMap<Integer,Integer> inOrderIndexMap,int[] postIndex,int inStart,int inEnd){
        if(postIndex[0] < 0 || inStart > inEnd)
            return null;
        
        int currentVal = postorder[postIndex[0]];
        TreeNode node = new TreeNode(currentVal);
        postIndex[0]--;
        int i = inOrderIndexMap.get(currentVal);
        
        node.right = constructTree(postorder,inOrderIndexMap,postIndex,i+1,inEnd);
        node.left = constructTree(postorder,inOrderIndexMap,postIndex,inStart,i-1);
        
        return node;
    }
    
     private void buildMap(HashMap<Integer,Integer> inOrderIndexMap,int[] inorder){
        
        for(int i = 0 ; i < inorder.length ; i++ )
            inOrderIndexMap.put(inorder[i],i);
    }
}