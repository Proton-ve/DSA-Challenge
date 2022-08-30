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
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> stack = new Stack();
        
        while(root!=null || !stack.isEmpty()){
            if(root==null){
                if(--k==0)
                    return stack.peek().val;
                root = stack.pop().right;
            }else{
                stack.push(root);
                root = root.left;
            }
        }
        
        return -1;
    }
}