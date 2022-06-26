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
    
    class Tuple{
        
        int val, col, row;
        TreeNode node;
        
        public Tuple(int val, int row, int col, TreeNode node){
            this.val = val;
            this.row = row;
            this.col = col;
            this.node = node;
        }
        
    }
    
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap();
        
        Queue<Tuple> q = new ArrayDeque();
        q.offer(new Tuple(root.val,0,0,root));
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i=0;i<size;i++){
                
                Tuple temp = q.poll();
                int row = temp.row, col = temp.col;

                if(!map.containsKey(col)){
                    map.put(col, new TreeMap());                
                }

                if(!map.get(col).containsKey(row)){
                    map.get(col).put(row,new PriorityQueue<Integer>());
                }

                map.get(col).get(row).offer(temp.val);

                TreeNode node = temp.node;

                if(node.left!=null){
                    q.offer(new Tuple(node.left.val,row+1, col-1, node.left));
                }

                if(node.right!=null){
                    q.offer(new Tuple(node.right.val,row+1, col+1, node.right));
                }
            }
        }

        List<List<Integer>> list = new ArrayList();

        for(TreeMap<Integer,PriorityQueue<Integer>> e : map.values()){
            
            list.add(new ArrayList());
                        
            for(PriorityQueue<Integer> f : e.values()){
                
                while(!f.isEmpty()){
                    list.get(list.size()-1).add(f.poll());
                }
            }
            
        }
        
        return list;
    }
}