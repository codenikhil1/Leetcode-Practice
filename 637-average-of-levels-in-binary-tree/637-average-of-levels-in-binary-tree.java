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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(queue.size() != 0){
            
            int currentSize = queue.size();
            int count = currentSize;
            double sum = 0;
            while(currentSize != 0){
                TreeNode currentNode = queue.remove();
                sum+= currentNode.val;
                
                if(currentNode.left != null)
                    queue.add(currentNode.left);
                if(currentNode.right != null)
                    queue.add(currentNode.right);
                
                
                currentSize--;
            }
            
            ans.add(sum/count);
        }
        
        return ans;
    } 
}