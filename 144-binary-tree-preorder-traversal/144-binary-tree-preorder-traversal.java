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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        if(root==null)return new ArrayList();
        
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        List<Integer> ans = new ArrayList();
        
        while(!stack.isEmpty()){
            
            ans.add(stack.peek().val);
            
            TreeNode temp = stack.pop();
            
            if(temp.right!=null)stack.push(temp.right);
            if(temp.left!=null)stack.push(temp.left);
        }
        
        return ans;
        
    }
}