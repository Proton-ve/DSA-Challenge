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
    
    String j = "->";
    
    public List<String> binaryTreePaths(TreeNode root) {
        
        return path(root,"");
    }
    
    public List<String> path(TreeNode node, String path){
        
        if(node==null)return new ArrayList();
        
        if(node.left==null && node.right==null){
            path = path+node.val;
            ArrayList<String> out = new ArrayList();
            out.add(path);
            path = "";
            return out;
        }
        
        ArrayList<String> ans = new ArrayList();
        path = path+node.val+j;
        
        ans.addAll(path(node.left, path));
        ans.addAll(path(node.right, path));
        
        return ans;
    }
}