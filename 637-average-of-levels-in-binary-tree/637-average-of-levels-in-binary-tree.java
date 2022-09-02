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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> list = new ArrayList();
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            int n = queue.size();
            double levelSum = 0;
            
            for(int i=0;i<n;i++){
                
                TreeNode cur = queue.poll();
                levelSum += cur.val;
                
                if(cur.right!=null)queue.offer(cur.right);
                if(cur.left!=null)queue.offer(cur.left);
                
            }
            
            list.add(levelSum/n);
            
        }
        
        
        return list;
    }
}