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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
       while(stack.size() != 0){
            TreeNode currentNode = stack.pop();
           if(currentNode != null)
                list.add(currentNode.val);
            if(currentNode.left != null)
                stack.push(currentNode.left);
            if(currentNode.right != null)
                stack.push(currentNode.right);
        }
        Collections.reverse(list);
        return list;
    }
}
