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
    public boolean findTarget(TreeNode root, int k) {
        
        
        return twoSum(root, k, root);
    }
    
    public boolean twoSum(TreeNode root, int k, TreeNode node){
        
        if(root==null)return false;
        
        int remain = k - root.val;
        
        if(remain*2!=k && search(node, remain))
            return true;
        else
            return twoSum(root.left, k, node) || twoSum(root.right, k, node);
    }
    
    public boolean search(TreeNode root, int target){
        
        if(root==null)return false;
        
        if(target==root.val)return true;
        
        if(target<root.val)
            return search(root.left, target);
        else
            return search(root.right, target);
        
    }
    
}