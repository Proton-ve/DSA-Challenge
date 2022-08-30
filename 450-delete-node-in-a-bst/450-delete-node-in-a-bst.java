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
    public TreeNode deleteNode(TreeNode root, int key) {
     
        TreeNode cur = root;
        TreeNode prev = root;
        
        while(cur!=null){            
            
            if(cur.val==key)
                break;
            
            if(key<cur.val){
                prev = cur;
                cur = cur.left;
            }else{
                prev = cur;
                cur = cur.right;
            }
        }
        
        if(cur==null)
            return root;
        
        if(cur==prev){
            return getJoint(cur);
        }
        
        if(prev.left==cur){
            prev.left = getJoint(cur);
        }else{
            prev.right = getJoint(cur);
        }
        
        return root;
    }
    
    public TreeNode getJoint(TreeNode node){
        
        if(node.left==null)return node.right;
        if(node.right==null)return node.left;
        
        TreeNode head = node.left;
        TreeNode ans = head;
        
        while(head.right!=null)
            head = head.right;
        
        head.right = node.right;
        // System.out.println("ehad is "+head.val);
        return ans;
    }
}