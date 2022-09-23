class Solution {
    
    class Pair{
        
        int key,val;
        
        public Pair(int key,int val){
            this.key = key;
            this.val = val;
        }
        
        // @Override
        // public int compareTo(Pair p1, Pair p2){
        //     return p1.val-p2.val;
        // }
        
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue(
            new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.key-b.key;
            }
        });
        
        int[] ans = new int[k];
        
        HashMap<Integer,Integer> map = new HashMap();
        
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            
            pq.offer(new Pair(e.getValue(),e.getKey()));
            
            if(pq.size()>k){
                pq.poll();
            }
            
        }
        
        for(int i=0;i<k;i++)
            ans[i] = pq.poll().val;
        
        return ans;
    }
}



/*


class Solution {
    
    class Pair{
        
        int key,val;
        
        public Pair(int key,int val){
            this.key = key;
            this.val = val;
        }
        
        // @Override
        // public int compareTo(Pair p1, Pair p2){
        //     return p1.val-p2.val;
        // }
        
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<Pair> pq = new PriorityQueue(
            new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return b.key-a.key;
            }
        });
        
        // PriorityQueue<Pair<Integer,Integer> > pq=
        //         new PriorityQueue<Pair<Integer,Integer>>(k, Comparator.comparing(Pair::getKey));
        
        ArrayList<Integer> list = new ArrayList();
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            pq.add(new Pair(Math.abs(arr[i]-x),arr[i]));
            System.out.println("added "+arr[i]);
            if(pq.size()>k)
                System.out.println("removed "+pq.poll().val);
        }
        
        System.out.println(pq.peek().key);
        
        while(!pq.isEmpty())
            list.add(0,pq.poll().val);
        
        return list;
    }
}


*/