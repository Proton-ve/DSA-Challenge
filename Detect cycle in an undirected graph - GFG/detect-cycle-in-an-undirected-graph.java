//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean[] visited = new boolean[V];
        // DFS
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(checkCycleDFS(adj, i, -1, visited))return true;
            }
        }
        return false;

        // BFS
        // boolean[] visited = new boolean[V];
        
        // for(int i=0;i<V;i++){
        //     if(!visited[i]){
        //         if(checkCycle(V, adj, visited, i))return true;
        //     }
        // }
        
        // return false;
    }
    
    
    public boolean checkCycleDFS(ArrayList<ArrayList<Integer>> adj, int node, int parent, boolean[] visited){

        visited[node] = true;

        for(Integer e : adj.get(node)){
            
            if(!visited[e]){
                if(checkCycleDFS(adj, e, node, visited))
                    return true;
            }else if(e!=parent)
                return true;
        }
        return false;
    }
    
    
    // BFS
    // class Data{
    //     int node, parent;
    //     Data(int node, int parent){
    //         this.node = node;
    //         this.parent = parent;
    //     }
    // }
    // public boolean checkCycle(int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int start){
        
    //     Queue<Data> que = new ArrayDeque<Data>();
        
    //     que.offer(new Data(start,-1));
    //     visited[start] = true;
        
    //     while(!que.isEmpty()){
            
    //         Data cur = que.poll();
    //         int node = cur.node;
    //         int parent = cur.parent;
            
    //         for(Integer e : adj.get(cur.node)){
                
    //             if(!visited[e] && e!=parent){
    //                 que.offer(new Data(e,node));
    //                 visited[e] = true;
    //             }else
    //                 if(e!=parent){
    //                     return true;
    //                 }
    //         }
    //     }
        
    //     return false;
    // }
}