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
        
        StringBuilder sb = new StringBuilder("");
        
        return path(root,sb);
    }
    
    public List<String> path(TreeNode node, StringBuilder path){

        ArrayList<String> ans = new ArrayList();
        
        path.append(node.val);
        
        if(node.left==null && node.right==null){
            ArrayList<String> out = new ArrayList();
            out.add(path.toString());
            return out;
        }
        
        path.append("->");
        
        int len = path.length();
        // System.out.println("path formed for node "+node.val+" len === "+len);
        
        if(node.left!=null)ans.addAll(path(node.left, path));
        path.setLength(len);
        if(node.right!=null)ans.addAll(path(node.right, path));
        path.setLength(len);
        
        return ans;
    }
}