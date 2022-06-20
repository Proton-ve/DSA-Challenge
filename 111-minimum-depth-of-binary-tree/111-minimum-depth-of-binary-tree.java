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
    public int minDepth(TreeNode root) {
        
        if(root==null)return 0;
        
        Queue<TreeNode> q = new ArrayDeque();
        TreeNode end = new TreeNode(101);
        q.add(root);
        q.add(end);
        int height = 0;
        
        while(!q.isEmpty() && q.peek()!=end){
            
            TreeNode cur = q.poll();

            if(cur.left==null && cur.right==null)return height+1;
            if(cur.left!=null)q.offer(cur.left);
            if(cur.right!=null)q.offer(cur.right);
            if(q.peek()==end){
                q.poll();
                q.offer(end);
                height++;
            }
            
        }
     
        return height;
        
    }
}

// Recursive
// public int minDepth(TreeNode root) {
        
//         if(root==null)return 0;
        
//         if(root.left==null && root.right==null)return 1;
        
//         int left = minDepth(root.left);
//         int right = minDepth(root.right);
        
//         return left==0||right==0?left+right+1:Math.min(left,right)+1;
//     }