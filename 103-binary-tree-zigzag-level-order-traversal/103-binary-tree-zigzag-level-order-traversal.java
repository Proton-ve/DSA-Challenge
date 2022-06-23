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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root==null)return new ArrayList<List<Integer>>();
        
        Queue<TreeNode> q = new ArrayDeque();
        ArrayList<List<Integer>>ans = new ArrayList();
        boolean flag = true;
        q.offer(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            List<Integer>level = new ArrayList(size);
            
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(!flag)level.add(0,node.val);
                else level.add(node.val);
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            flag = !flag;
            ans.add(level);
        }

        return ans;
    }
}