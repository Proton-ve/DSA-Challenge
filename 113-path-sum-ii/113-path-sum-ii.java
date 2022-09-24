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
        
        List<List<Integer>> paths = new ArrayList();
        if(root==null)return paths;
        List<Integer> out = new ArrayList();
        out.add(root.val);
        sum(root,targetSum,root.val,out,paths);
        return paths;
    }
    
    public void sum(TreeNode root, int target, int curSum, List<Integer> out, List<List<Integer>> paths){
        
        if(root.left==null && root.right==null){
            if(curSum==target)
                paths.add(new ArrayList(out));
            return;
        }
         
        if(root.left!=null){
            out.add(root.left.val);
            sum(root.left,target,curSum+root.left.val,out,paths);
            out.remove(out.size()-1);
        }
        if(root.right!=null){
            out.add(root.right.val);
            sum(root.right,target,curSum+root.right.val,out,paths);
            out.remove(out.size()-1);
        }

        return;
    }
    
}