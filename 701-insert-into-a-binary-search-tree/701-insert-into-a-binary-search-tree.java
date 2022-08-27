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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        TreeNode ans = root;
        TreeNode prev = root;
        
        if(root==null)
            return new TreeNode(val);
        
        while(root!=null){
            
            if(val<root.val){
                prev = root;
                root = root.left;
            }else{
                prev = root;
                root = root.right;
            }
            
        }
        
        if(val>prev.val)
            prev.right = new TreeNode(val);
        else
            prev.left = new TreeNode(val);
        
        return ans;
    }
}