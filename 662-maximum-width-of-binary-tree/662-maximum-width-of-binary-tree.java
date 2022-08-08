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
    
    class Pair{
        
        TreeNode node;
        long pos;
        
        public Pair(TreeNode node, long pos){
            this.node = node;
            this.pos = pos;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {

        Queue<Pair> queue = new ArrayDeque();
        queue.offer(new Pair(root,0));
        long ans = 0;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            long minPos = 1;
            long maxPos = 1;
           
            for(int i=0;i<size;i++){    
                
                TreeNode cur = queue.peek().node;
                long curPos = queue.poll().pos;
                
                if(i==0)minPos = curPos;
                if(i==size-1)maxPos = curPos;
                
                // System.out.println("curNode is "+cur.val+" curPos "+curPos);
                if(cur.left!=null){
                    // long pos = curPos*2;
                    // minPos = Math.min(pos, minPos);
                    // maxPos = Math.max(pos, maxPos);
                    queue.offer(new Pair(cur.left, curPos*2));
                }
                
                if(cur.right!=null){
                    // long pos = curPos*2+1;
                    // minPos = Math.min(pos, minPos);
                    // maxPos = Math.max(pos, maxPos);
                    queue.offer(new Pair(cur.right, curPos*2+1));
                }                
            }
         
            // System.out.println(minPos+" min   max "+maxPos);
            ans = Math.max(ans, maxPos-minPos+1);
        }
           
        return (int)ans;
    }
}
