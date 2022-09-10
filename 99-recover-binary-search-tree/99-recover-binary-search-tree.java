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
    public void recoverTree(TreeNode root) {
        
        TreeNode firstSwap = null, secondSwap = null;
        TreeNode cur = root;
        
        List<TreeNode> inorder = new ArrayList();
        
        while(cur!=null){
            
            if(cur.left==null){
                inorder.add(cur);
                cur = cur.right;
            }else{
                TreeNode predec = findPredec(cur);
            
                if(predec.right==cur){
                    predec.right = null;
                    inorder.add(cur);
                    cur = cur.right;
                }else{
                    predec.right = cur;
                    cur = cur.left;
                }
            }
       
        }
        
        int n = inorder.size();
        boolean first=true;
        
        for(int i=1;i<n;i++){
            
            if(inorder.get(i-1).val>inorder.get(i).val){
                if(first){
                    firstSwap = inorder.get(i-1);
                    secondSwap = inorder.get(i);
                    first=false;
                }else{
                    secondSwap = inorder.get(i);
                    break;
                }
            }
        }
        
        int temp = firstSwap.val;
        firstSwap.val = secondSwap.val;
        secondSwap.val = temp;
        
        // System.out.println(inorder);
        
    }
    
    public TreeNode findPredec(TreeNode root){
        
        TreeNode cur = root.left;
        
        while(cur.right!=null && cur.right!=root){
            // System.out.println(cur.val);
            cur = cur.right;
        }
        return cur;
    }
    
}