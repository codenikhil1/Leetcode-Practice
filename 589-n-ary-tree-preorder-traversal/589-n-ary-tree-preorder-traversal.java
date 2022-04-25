/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
           List<Integer> list = new ArrayList<>();
        if(root == null)
           return list;
        /*
        preorder(root,list);
        return list;  */
        
        //using iterative approach - stack
        
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(stack.size() != 0){
            Node currentNode = stack.pop();
            list.add(currentNode.val);
            
            for(int i = currentNode.children.size()-1 ; i >=0  ; i-- ){
                stack.add(currentNode.children.get(i));
            }
           
        }
        return list;
    }
}