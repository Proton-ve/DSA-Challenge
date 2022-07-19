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
    
    int max = Integer.MIN_VALUE;
    
    public int diameterOfBinaryTree(TreeNode root) {
                
        int a = height(root.left);
        int b = height(root.right);
                
        return Math.max(max,(a+b));
    }
    
    public int height(TreeNode node){

    
        if(node==null)return 0;
        
        int left = height(node.left);
        int right = height(node.right);
        
        max = Math.max(max,(left+right));
        
        return Math.max(left,right)+1;
    
    }
    
}