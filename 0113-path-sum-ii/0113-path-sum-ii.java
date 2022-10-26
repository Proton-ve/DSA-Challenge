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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        return worker(root,targetSum,targetSum,new ArrayList());
    }
    
    public List<List<Integer>> worker(TreeNode root, int targetSum, int curSum, List<Integer> out) {
        
        List<List<Integer>> list = new ArrayList();
        
        if(root==null)return list;
        
        out.add(root.val);
        
        if(root.left==null && root.right==null){
            if(curSum-root.val==0){
                list.add(new ArrayList(out)); 
            }
            return list;
        }
        
        if(root.left!=null){
            list.addAll(worker(root.left, targetSum, curSum - root.val, out));
            out.remove(out.size()-1);
        }
        
        if(root.right!=null){
            list.addAll(worker(root.right, targetSum, curSum - root.val, out));
            out.remove(out.size()-1);
        }
        
        return list;
    }
    
}