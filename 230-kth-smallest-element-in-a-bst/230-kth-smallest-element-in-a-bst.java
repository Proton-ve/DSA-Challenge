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
    public int kthSmallest(TreeNode root, int k) {
        
        TreeNode cur = root;
        
        while(cur!=null){
            
            if(cur.left==null){
                if(--k==0)return cur.val;
                cur = cur.right;
            }else{
                TreeNode predec = findPredec(cur.left, cur);
                if(predec.right==cur){
                    predec.right =null;
                    if(--k==0)
                        return cur.val;
                    cur = cur.right;
                }else{
                    predec.right = cur; 
                    cur = cur.left;
                }
                
            }
                                    
        }
        return -1;
    }
    
    public TreeNode findPredec(TreeNode node, TreeNode cur){
        
        while(node.right!=null && node.right!=cur)
            node = node.right;
        
        return node;
    }
    
}