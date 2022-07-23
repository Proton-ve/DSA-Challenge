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
    
    int myMax = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {

        if(root.left==null && root.right==null)return root.val;
        
        maxSum(root);
        
        return myMax;
        
    }
    
    public int maxSum(TreeNode root){
                
        if(root==null)return 0;
        
        int left = maxSum(root.left);
        int right = maxSum(root.right);
        
        left = left<0?0:left;
        right = right<0?0:right;
        
        myMax = Math.max(myMax, left+right+root.val);
        
        return Math.max(left,right)+root.val;
    }
    
}