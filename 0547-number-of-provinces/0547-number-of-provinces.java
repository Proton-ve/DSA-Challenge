class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList();
        int n = isConnected.length;
        
        for(int i=0;i<n;i++){
            ArrayList<Integer> curList = new ArrayList();
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    curList.add(j);
                }
            }
            list.add(curList);
        }
        
        boolean[] vis = new boolean[n];
        int count = 0;
        
        for(int i=0;i<n;i++){
            
            if(!vis[i]){
                count++;
                dfs(i,list,vis);
            }
        }
        
        return count;
    }
    
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        
        vis[node] = true;
        
        for(Integer e : adj.get(node)){
            if(!vis[e])
                dfs(e, adj, vis);
            
        }
    } 
    
    
}