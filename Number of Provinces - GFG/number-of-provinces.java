//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int ans = 0;
        boolean[] visited = new boolean[V];
        
        // Adjacentcy matrix representation
        // for(ArrayList<Integer> e : adj){
        //     for(Integer f : e){
        //         System.out.print(f+" ");
        //     }
        //     System.out.println();
        // }
        
        
        
        for(int i=0;i<V;i++){
            
            // if(!visited[i]){
            //     ans++;
            //     dfs(i,adj,visited);
            // }
        
            if(!visited[i]){
                
                ans++;
                visited[i] = true;
                Queue<Integer> q = new ArrayDeque<Integer>();
                q.offer(i);
                // System.out.println("root "+i);
                while(!q.isEmpty()){
                    
                    Integer cur = q.poll();
                    
                    ArrayList<Integer> edge = adj.get(cur);
                    
                    for(int e=0;e<edge.size();e++){
                        if(edge.get(e)==1 && !visited[e]){
                            // System.out.println("e is "+e);
                            q.offer(e);
                            visited[e] = true;   
                        }
                    }
                }
            }
        }
        
        return ans;
    }
    
    
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        
            visited[node] = true;
    
            for(Integer e : adj.get(node))
                if(!visited[e])
                    dfs(e, adj, visited);

    }
    
};