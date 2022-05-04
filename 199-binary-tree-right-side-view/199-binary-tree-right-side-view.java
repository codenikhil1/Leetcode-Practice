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
    public List<Integer> rightSideView(TreeNode root) {
          List<Integer> ans = new ArrayList<>();
        //left(map,ans,root,0);
        right(ans,root,0);
      
      
      return ans;
    }
    
    public void right(List<Integer> ans,TreeNode node, int currentLevel){
        if(node == null)
         return;
         
        // if(!map.containsKey(currentLevel)){
        //     map.put(currentLevel,node.data);
        //     ans.add(node.data);
        // }
        if(ans.size() == currentLevel){
            ans.add(node.val);
        }
        
        right(ans,node.right,currentLevel+1);
        right(ans,node.left,currentLevel+1);
        
    }
}