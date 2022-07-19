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
    public List<Integer> postorderTraversal(TreeNode root) {
     
        Stack<TreeNode> stack = new Stack();
        List<Integer> ans = new ArrayList();
        TreeNode cur = root;
        
        while(!stack.isEmpty() || cur!=null){
                        
            
            
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                            
               TreeNode temp = stack.peek().right;
                
                if(temp==null){
                    
                    temp = stack.pop();
                    ans.add(temp.val);     
                    
                        while(!stack.isEmpty() && stack.peek().right==temp){
                            temp = stack.pop();
                            ans.add(temp.val);                        
                        }
                    
                }
                else cur = temp;
                
            } 
        }
        
       return ans; 
    }
}