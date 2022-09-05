/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        
        Queue<Node> q = new ArrayDeque();
        List<List<Integer>> list = new ArrayList();
        
        if(root==null)return list;
        
        q.offer(root);
        List<Integer> cur = new ArrayList();
        cur.add(root.val);
        list.add(cur);
        
        while(!q.isEmpty()){
            
            int n = q.size();
            
            ArrayList<Integer> curChildren = new ArrayList();
            
            for(int i=0;i<n;i++){
                
                Node curNode = q.poll();
                
                for(Node e : curNode.children){
                    q.offer(e);
                    curChildren.add(e.val);
                }
                
            }
            
            if(!curChildren.isEmpty())
                list.add(curChildren);
            
        }
        
        
        return list;
        
    }
}