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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        HashMap<Integer, Integer> indexMap = new HashMap();
        int n = inorder.length;
        
        for(int i=0;i<n;i++)
            indexMap.put(inorder[i],i);
        
        return builder(inorder, 0, n, postorder, 0, postorder.length-1, indexMap);
    }
    
    public TreeNode builder(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> map){
        
        if(inStart>inEnd || postStart>postEnd)return null;
        
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        int rootInd = map.get(postorder[postEnd]);
        
        int leftNodeCount = rootInd - inStart;
        
        root.left = builder(inorder, inStart, rootInd-1, postorder, postStart, postStart+leftNodeCount-1, map);
        root.right = builder(inorder, rootInd+1, inEnd, postorder, postStart+leftNodeCount, postEnd-1, map);
        
        return root;
    }
    
    
}