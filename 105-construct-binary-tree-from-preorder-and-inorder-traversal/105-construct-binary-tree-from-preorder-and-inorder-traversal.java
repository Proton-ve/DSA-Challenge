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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
            
        HashMap<Integer, Integer> indexMap = new HashMap();
        int n = inorder.length;
        
        for(int i=0;i<n;i++)
            indexMap.put(inorder[i],i);
        
        return builder(preorder, 0, inorder, 0, n, indexMap);
            
    }
    
    public TreeNode builder(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> map){
        
        if(preStart>preorder.length-1 || inStart>inEnd)return null;
        
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        //get root pos in Inorder
        int rootIndex = map.get(preorder[preStart]);
        
        int leftCount = rootIndex - inStart;
        
        root.left = builder(preorder,  preStart+1, inorder, inStart, rootIndex-1, map);
        root.right = builder(preorder, preStart+leftCount+1, inorder, rootIndex+1, inEnd, map);
        
        return root;
        
    }
    
}