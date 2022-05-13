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
        
        if(root==null) return new ArrayList();
         
        Stack<TreeNode> nodes = new Stack();
        List<Integer> ans = new ArrayList();
        
        nodes.add(root);
        
        while(!nodes.isEmpty()){
            
            TreeNode parent = nodes.pop();
            ans.add(parent.val);
            
            if(parent.right!=null)nodes.push(parent.right);
            if(parent.left!=null)nodes.push(parent.left);
            
            
        }
        
        return ans;
        
    }
    
    
    
//     Recursive
//     public List<Integer> preorderTraversal(TreeNode root) {
        
//         ArrayList<Integer> ans = new ArrayList();
        
//         if(root==null){
//             return new ArrayList();
            
//         }
        
//         ans.add(root.val);
//         ans.addAll(preorderTraversal(root.left));
//         ans.addAll(preorderTraversal(root.right));
        
//         return ans;
//     }
    
    
}