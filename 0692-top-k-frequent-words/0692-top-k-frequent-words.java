class Solution {
    
    class Pair{
        
        int freq;
        String str;
        
        Pair(String str, int freq){
            this.freq = freq;
            this.str = str;
        }
        
    }
    
    
    public List<String> topKFrequent(String[] words, int k) {
     
        HashMap<String,Integer> map = new HashMap();
        
        PriorityQueue<Pair> pq = new PriorityQueue( new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.freq==b.freq ? b.str.compareTo(a.str) : a.freq - b.freq;
            }
        });
        
        int n = words.length;
        
        for(int i=0;i<n;i++)
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        
        
        for(Map.Entry<String,Integer> e : map.entrySet()){
            pq.offer(new Pair(e.getKey(),e.getValue()));
            if(pq.size()>k)
                pq.poll();
        }
        
        List<String> list = new ArrayList();
        
        while(!pq.isEmpty())
            list.add(0,pq.poll().str);
        
        return list;
    }
}