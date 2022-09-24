class Solution {
    
    class Pair{
        
        char key;
        int val;
        
        public Pair(char key, int val){
            this.key = key;
            this.val = val;
        }
        
    }
    
    public String frequencySort(String s) {
        
        PriorityQueue<Pair> pq = new PriorityQueue(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return b.val - a.val;
            }
        });
        
        HashMap<Character,Integer> map = new HashMap();
        
        int n = s.length();
        
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        for(Map.Entry<Character,Integer> e : map.entrySet())
            pq.offer(new Pair(e.getKey(),e.getValue()));
        
        StringBuilder sb = new StringBuilder("");
        
        while(!pq.isEmpty()){
            Pair obj = pq.poll();
            for(int i=0;i<obj.val;i++)
                sb.append(obj.key);
        }
            
        return sb.toString();
    }
}