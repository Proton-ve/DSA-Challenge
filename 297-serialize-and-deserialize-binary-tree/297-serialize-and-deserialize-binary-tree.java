/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root==null)return "";
        
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        
        StringBuilder ans = new StringBuilder("");
        ans.append(root.val+",");

        while(!queue.isEmpty()){
            
            int n = queue.size();
            
            for(int i=0; i<n; i++){
                
                TreeNode temp = queue.poll();
                
                if(temp.left!=null){
                    queue.offer(temp.left);
                    ans.append(temp.left.val+",");
                }else
                    ans.append("N,");
                
                
                if(temp.right!=null){
                    queue.offer(temp.right);
                    ans.append(temp.right.val+",");
                }else
                    ans.append("N,");
            }
        }
                
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.equals(""))return null;
        
        
        String[] arr = data.split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        int i=1;
        
        while(!queue.isEmpty()){
            
            TreeNode temp = queue.poll();
            
            if(!arr[i].equals("N")){
                TreeNode tempLeft = new TreeNode(Integer.parseInt(arr[i++]));
                queue.offer(tempLeft);
                temp.left = tempLeft;
            }else
                i++;
            
            if(!arr[i].equals("N")){
                TreeNode tempRight = new TreeNode(Integer.parseInt(arr[i++]));
                queue.offer(tempRight);
                temp.right = tempRight;
            }else
                i++;
            
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));