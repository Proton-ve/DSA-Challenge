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
    
    int i=0;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        
        return treeBuilder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode treeBuilder(int[] preorder, int low, int high){
        
        if(i>=preorder.length || preorder[i]>high || preorder[i]<low)
            return null;
        
        TreeNode node = new TreeNode(preorder[i++]);
        
        node.left = treeBuilder(preorder, low, node.val);
        node.right = treeBuilder(preorder, node.val, high);
        
        return node;
    }
    
    
}