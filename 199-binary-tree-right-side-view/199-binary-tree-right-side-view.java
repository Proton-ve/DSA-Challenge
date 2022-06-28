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
    public List<Integer> rightSideView(TreeNode root) {
     
        ArrayList<Integer> ans = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap();

        traverse(root,0, map);
        
        for(Integer e : map.values())ans.add(e);
        
        return ans;
        
    }
    
        void traverse(TreeNode root, int row, HashMap<Integer, Integer> map){
        
            if(root==null)return;

            if(!map.containsKey(row)){
                // System.out.println("row is "+row+" data is "+root.data);
                map.put(row,root.val);
            }

            
            traverse(root.right,row+1, map);
            traverse(root.left,row+1, map);

            return;
    }
    
}