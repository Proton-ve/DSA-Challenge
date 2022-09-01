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
    public int goodNodes(TreeNode root) {
        
        return countGoodNodes(root, root.val);
    }
    
    public int countGoodNodes(TreeNode node, int max){
        
        if(node==null)
            return 0;
                
        int count = 0;
        
        if(max<=node.val){
            count=1;
            max = node.val;
        }
        
        int temp = max;
        
        count += countGoodNodes(node.left, max);
        count += countGoodNodes(node.right, temp);
        
        return count;
    }
    
}