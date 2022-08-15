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
    public int countNodes(TreeNode root) {
       
        if(root==null)return 0;
        
        int leftHeight = getHeight(root, true),
            rightHeight = getHeight(root, false);
        
        if(leftHeight==rightHeight)
            return (int)Math.pow(2,rightHeight)-1;
        
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        
        return left+right+1;
        
    }
    
    public int getHeight(TreeNode root, boolean leftmost){
        
        int height = 0;
        
//         left height
        if(leftmost){
            while(root!=null){
                root=root.left;
                height++;
            }
            return height;
        }
        
//         right height
        while(root!=null){
            root=root.right;
            height++;
        }
        return height;
    }
    
}