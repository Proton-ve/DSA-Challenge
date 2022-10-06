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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if(depth==1){
            TreeNode ans = new TreeNode(val);
            ans.left = root;
            return ans;
        }
        
        Queue<TreeNode> q = new ArrayDeque();
        
        q.offer(root);
        
        while(--depth>0 || !q.isEmpty()){
            
            int n = q.size();
            
            for(int i=0;i<n;i++){
                
                TreeNode cur = q.poll();
                                
                if(cur.left!=null)q.offer(cur.left);
                if(cur.right!=null)q.offer(cur.right);
                
                if(depth==1){
                    TreeNode tempLeft = cur.left;
                    TreeNode tempRight = cur.right;
                    
                    cur.left = new TreeNode(val);
                    cur.right = new TreeNode(val);
                    
                    cur.left.left = tempLeft;
                    cur.right.right = tempRight;
                }
            }
        }
    
        return root;
    }
}