class Solution {
    
    class Pair{
        
        int key;
        int val;
        
        public Pair(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        
        int[][] ans = new int[k][2];
        
        PriorityQueue<Pair> pq = new PriorityQueue(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return b.key - a.key;
            }
        });
        
        int n = points.length;
        
        for(int i=0;i<n;i++){
            
            int x = points[i][0],
                y = points[i][1];
            
            int distance = (int)(Math.pow(x,2)+Math.pow(y,2));
            pq.offer(new Pair(distance,i));
            
            if(pq.size()>k)
                pq.poll();
        }
        
        int j=0;
        
        while(!pq.isEmpty())
            ans[j++] = points[pq.poll().val];
        
        return ans;
    }
}