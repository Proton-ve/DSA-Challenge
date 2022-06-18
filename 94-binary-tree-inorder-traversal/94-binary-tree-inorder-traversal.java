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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        TreeNode node = root;
        List<Integer> ans = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        
        while(true){
            
            if(node!=null){
                stack.push(node);
                node = node.left;
            }else{
                if(stack.isEmpty())break;
                ans.add(stack.peek().val);
                node = stack.pop().right;   
            }
        }
        
        return ans;
    }
    
    
    
    // recursive
//     public List<Integer> inorderTraversal(TreeNode root) {
     
//         ArrayList<Integer> ans = new ArrayList();
        
//         if(root==null){
//             return new ArrayList();
            
//         }
        
        
//         ans.addAll(inorderTraversal(root.left));
//         ans.add(root.val);
//         ans.addAll(inorderTraversal(root.right));
        
//         return ans;
        
//     }
    
}