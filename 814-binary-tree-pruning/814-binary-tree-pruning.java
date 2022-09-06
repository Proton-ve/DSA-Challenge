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
    public TreeNode pruneTree(TreeNode root) {
        return checker(root)?root:null;
    }
    
    
    public boolean checker(TreeNode root){
        
        if(root==null)
            return false;
        
        boolean left = checker(root.left);
        
        if(!left)
            root.left=null;
        
        boolean right = checker(root.right);
        
        if(!right)
            root.right=null;
 
        return left || right || root.val==1;
    }
    
}