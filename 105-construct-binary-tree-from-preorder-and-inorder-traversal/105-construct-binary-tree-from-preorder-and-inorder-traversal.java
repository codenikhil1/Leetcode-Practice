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
        HashMap<Integer,Integer> inOrderIndexMap = new HashMap<>();
        buildMap(inOrderIndexMap,inorder);
        return constructTree(preorder,inOrderIndexMap,preIndex,0,inorder.length - 1);
    }
    private void buildMap(HashMap<Integer,Integer> inOrderIndexMap,int[] inorder){
        
        for(int i = 0 ; i < inorder.length ; i++ )
            inOrderIndexMap.put(inorder[i],i);
    }
    private TreeNode constructTree(int[] preorder,HashMap<Integer,Integer> inOrderIndexMap,int[] preIndex,int inStart,int inEnd){
        if(preIndex[0] > preorder.length || inStart > inEnd)
            return null;
        
        int currentVal = preorder[preIndex[0]];
        TreeNode node = new TreeNode(currentVal);
        preIndex[0]++;
        int i = inOrderIndexMap.get(currentVal);
        
        node.left = constructTree(preorder,inOrderIndexMap,preIndex,inStart,i-1);
        node.right = constructTree(preorder,inOrderIndexMap,preIndex,i+1,inEnd);
        
        return node;
    }
}