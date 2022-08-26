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
    public void flatten(TreeNode root) {
        
        TreeNode cur = root;
        
        while(cur!=null){
            
            if(cur.left!=null){
                
                TreeNode parent = cur.left;
                TreeNode prev = cur.left;
                TreeNode next = cur.right;
                
//                 Find Predecessor
                while(prev.right!=null)
                    prev = prev.right;
                
                prev.right = next;
                cur.right = parent;
                cur.left = null;
                                    
            }
                
            cur = cur.right;
            
        }
        
    }
}