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
    public int maxDepth(TreeNode root) {
        
        if(root==null)return 0;
        
        Queue<TreeNode> q = new ArrayDeque();
        TreeNode end = new TreeNode(101);
        q.add(root);
        q.add(end);
        int height = 0;
        
        while(!q.isEmpty() && q.peek()!=end){
            
            TreeNode cur = q.poll();

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

/*
Recursive

public int maxDepth(TreeNode root) {
        
        if(root==null)return 0;
        
        if(root.left==null && root.right==null)return 1;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left,right)+1;
        
    }

*/