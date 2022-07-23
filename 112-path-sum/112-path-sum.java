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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        return checkPath(root,targetSum, 0);

    }
    
    public boolean checkPath(TreeNode root, int targetSum, int pathSum){
        
        if(root==null)return false;
        
        if(root.right==null && root.left==null)
            return pathSum+root.val==targetSum;
        
        boolean left = checkPath(root.left, targetSum, pathSum+root.val);
        boolean right = checkPath(root.right, targetSum, pathSum+root.val);
        
        return left||right;
        
    }
    
}